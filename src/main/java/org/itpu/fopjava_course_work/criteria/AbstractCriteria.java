package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.validators.FieldValidator;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCriteria<A extends Appliance<A>>
        implements SearchCriteria<A> {

    private final Class<A> persistantClass;
    protected final Map<Class<A>, List<FieldValidator>> fieldValidators = new HashMap<>();

    @SuppressWarnings("unchecked")
    public AbstractCriteria() {
        persistantClass = (Class<A>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<A> getApplianceType() {
        return persistantClass;
    }

    @Override
    public SearchCriteria<A> add(Class<A> clazz, FieldValidator fieldValidator) {
        fieldValidators.putIfAbsent(clazz, new ArrayList<>());
        fieldValidators.get(clazz).add(fieldValidator);
        return this;
    }

    @Override
    public boolean test(A appliance) {
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
