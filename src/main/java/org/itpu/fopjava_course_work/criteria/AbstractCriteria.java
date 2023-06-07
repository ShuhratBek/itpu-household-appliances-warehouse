package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.Appliance;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<A extends Appliance<A>>
        implements SearchCriteria<A> {

    private final Class<A> persistantClass;
    protected final Map<Class<?>, Parameter<A>> parameters = new HashMap<>();

    @SuppressWarnings("unchecked")
    public AbstractCriteria() {
        persistantClass = (Class<A>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<A> getApplianceType() {
        return persistantClass;
    }

    @Override
    public <F extends Parameter<A>> SearchCriteria<A> add(F parameter) {
        parameters.put(parameter.getClass(), parameter);
        return this;
    }

    @Override
    public boolean test(A appliance) {
        for (Parameter<A> parameter : parameters.values()) {
            if (!parameter.test(appliance)) {
                return false;
            }
        }
        return true;
    }
}
