package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.itpu.fopjava_course_work.validators.FieldValidator;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;

public abstract class AbstractController<T extends Appliance<T>> {
    protected final ApplianceService applianceService;

    private final Class<T> persistantClass;

    @SuppressWarnings("unchecked")
    public AbstractController(ApplianceService applianceService) {
        this.applianceService = applianceService;
        persistantClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected abstract SearchCriteria<T> createCriteria();

    protected Collection<T> getAll() {
        return applianceService.find(createCriteria());
    }

    protected Collection<T> findBy(Map<String, String> searchParameters) {
        SearchCriteria<T> searchCriteria = createCriteria();
        for (Map.Entry<String, String> entry : searchParameters.entrySet()) {
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();
            searchCriteria.add(persistantClass, new FieldValidator(attributeName, attributeValue));
        }
        return applianceService.find(searchCriteria);
    }
}
