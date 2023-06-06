package org.itpu.fopjava_course_work.criteria;

import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.Appliance;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<A extends Appliance<A>>
        implements SearchCriteria<A> {

    protected final Map<Class<?>, Parameter<A>> parameters = new HashMap<>();

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
