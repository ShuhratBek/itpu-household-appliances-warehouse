package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.converter.ParameterConverter;
import org.itpu.fopjava_course_work.converter.RawConverters;
import org.itpu.fopjava_course_work.criteria.DryerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.entity.Dryer;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.service.ApplianceService;

import java.util.Collection;
import java.util.Map;

public class DryerController extends ConcreteController<Dryer> {

    public DryerController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected Collection<Dryer> findAll() {
        return applianceService.find(createCriteria());
    }

    @Override
    protected Collection<Dryer> find(Map<String, String> searchParameters) {
        DryerSearchCriteria searchCriteria = new DryerSearchCriteria();
        for (Map.Entry<String, String> entry : searchParameters.entrySet()) {
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();

            // Use the RawConverters enum to obtain the appropriate converter based on the attribute name
            RawConverters rawConverter = RawConverters.valueOf(attributeName.toUpperCase());
            ParameterConverter<Dryer> converter = rawConverter.generic();

            // Convert the attribute value into a Parameter object using the converter
            Parameter<Dryer> parameter = converter.convert(attributeValue);

            // Set the parameter in the search criteria
            searchCriteria.add(parameter);
        }
        return applianceService.find(searchCriteria);
    }

    @Override
    protected SearchCriteria<Dryer> createCriteria() {
        return new DryerSearchCriteria();
    }
}