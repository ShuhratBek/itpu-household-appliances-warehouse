package org.itpu.fopjava_course_work.validators;

import org.itpu.fopjava_course_work.entity.Appliance;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class FieldValidator {
    public String fieldName;
    public Object fieldValue;
    public String fieldValueMin = null;
    public String fieldValueMax = null;

    public FieldValidator(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        if (fieldValue.toString().contains("-")) {
            try {
                String[] minMax = fieldValue.toString().split("-");
                fieldValueMin = minMax[0];
                fieldValueMax = minMax[1];
                if (isNumber(fieldValueMin) && isNumber(fieldValueMax)) {
                    this.fieldValue = null;
                }
            } catch (Throwable t) {
                // is not a range
            }
        }
    }

    public static boolean isNumber(Object obj) {
        return Pattern.matches("[0-9]{1,13}(\\.[0-9]*)?", obj.toString());
    }

    public <T extends Appliance<T>>boolean test(T appliance) {
        Object value = getTypedValue(appliance);
        if (fieldValue != null && value != null) {
            return fieldValue.equals(value.toString());
        } else {
            if (value != null) {
                if (fieldValueMin != null && fieldValueMax != null) {
                    if (value instanceof Integer) {
                        return (Integer.parseInt(fieldValueMin) < (Integer) value) && Integer.parseInt(fieldValueMax) > (Integer) value;
                    } else if (value instanceof Double) {
                        return (Double.parseDouble(fieldValueMin) < (Double) value) && Double.parseDouble(fieldValueMax) > (Double) value;
                    } else if (value instanceof Long) {
                        return (Long.parseLong(fieldValueMin) < (Long) value) && Long.parseLong(fieldValueMax) > (Long) value;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return true;
            }

        }
    }

    private <T extends Appliance<T>>Object getTypedValue(T appliance) {
        if (appliance != null) {
            try {
                return getFieldValue(appliance);
            } catch (Throwable t) {
                try {
                    return getSuperFieldValue(appliance);
                } catch (Throwable t1) {
                    return null;
                }
            }
        }
        return null;
    }

    public Object getFieldValue(Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);

        field.setAccessible(true);
        return field.get(object);
    }

    public Object getSuperFieldValue(Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getSuperclass().getDeclaredField(fieldName);

        field.setAccessible(true);
        return field.get(object);
    }
}
