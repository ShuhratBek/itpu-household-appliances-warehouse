package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCriteria<T extends Appliance<T>>
        implements SearchCriteria<T> {

    private final Class<T> persistantClass;
    protected final Map<Class<T>, List<FieldValidator>> fieldValidators = new HashMap<>();

    @SuppressWarnings("unchecked")
    public AbstractCriteria() {
        persistantClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getApplianceType() {
        return persistantClass;
    }

    @Override
    public SearchCriteria<T> add(Class<T> clazz, FieldValidator fieldValidator) {
        fieldValidators.putIfAbsent(clazz, new ArrayList<>());
        fieldValidators.get(clazz).add(fieldValidator);
        return this;
    }

    @Override
    public boolean test(T appliance) {
        if (fieldValidators.containsKey(appliance.getClass())) {
            for (FieldValidator fieldValidator : fieldValidators.get(appliance.getClass())) {
                if (!fieldValidator.test(appliance)) {
                    return false;
                }
            }
        }
        return true;
    }
}
