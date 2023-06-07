package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.converter.ParameterConverter;
import org.itpu.fopjava_course_work.converter.RawConverters;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.service.ApplianceService;

import java.util.Collection;
import java.util.Map;

public abstract class ConcreteController<A extends Appliance<A>> {
    protected final ApplianceService applianceService;

    public ConcreteController(ApplianceService applianceService) {
        this.applianceService = applianceService;
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

            // Use the RawConverters enum to obtain the appropriate converter based on the attribute name
            RawConverters rawConverter = RawConverters.valueOf(attributeName.toUpperCase());
            ParameterConverter<A> converter = rawConverter.generic();

            // Convert the attribute value into a Parameter object using the converter
            Parameter<A> parameter = converter.convert(attributeValue);

            // Set the parameter in the search criteria
            searchCriteria.add(parameter);
        }
        return applianceService.find(searchCriteria);
    }
}
