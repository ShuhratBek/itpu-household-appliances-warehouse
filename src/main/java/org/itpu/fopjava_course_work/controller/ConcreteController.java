package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.itpu.fopjava_course_work.validators.FieldValidator;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;

public abstract class ConcreteController<A extends Appliance<A>> {
    protected final ApplianceService applianceService;

    private final Class<A> persistantClass;

    @SuppressWarnings("unchecked")
    public ConcreteController(ApplianceService applianceService) {
        this.applianceService = applianceService;
        persistantClass = (Class<A>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
    protected abstract SearchCriteria<A> createCriteria();
    protected Collection<A> findAll() {
        return applianceService.find(createCriteria());
    }
    protected Collection<A> find(Map<String, String> searchParameters) {
        SearchCriteria<A> searchCriteria = createCriteria();
        for (Map.Entry<String, String> entry : searchParameters.entrySet()) {
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();

            // Set the parameter in the search criteria
            searchCriteria.add(persistantClass, new FieldValidator(attributeName, attributeValue));
        }
        return applianceService.find(searchCriteria);
    }
}
