package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.converter.ParameterConverter;
import org.itpu.fopjava_course_work.converter.RawConverters;
import org.itpu.fopjava_course_work.criteria.ClothesSteamerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.ClothesSteamer;
import org.itpu.fopjava_course_work.service.ApplianceService;
import java.util.Collection;
import java.util.Map;

public class ClothesSteamerController extends ConcreteController<ClothesSteamer> {

    public ClothesSteamerController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected Collection<ClothesSteamer> findAll() {
        return applianceService.find(createCriteria());
    }

    @Override
    protected Collection<ClothesSteamer> find(Map<String, String> searchParameters) {
        ClothesSteamerSearchCriteria searchCriteria = new ClothesSteamerSearchCriteria();
        for (Map.Entry<String, String> entry : searchParameters.entrySet()) {
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();

            // Use the RawConverters enum to obtain the appropriate converter based on the attribute name
            RawConverters rawConverter = RawConverters.valueOf(attributeName.toUpperCase());
            ParameterConverter<ClothesSteamer> converter = rawConverter.generic();

            // Convert the attribute value into a Parameter object using the converter
            Parameter<ClothesSteamer> parameter = converter.convert(attributeValue);

            // Set the parameter in the search criteria
            searchCriteria.add(parameter);
        }
        return applianceService.find(searchCriteria);
    }

    @Override
    protected SearchCriteria<ClothesSteamer> createCriteria() {
        return new ClothesSteamerSearchCriteria();
    }
}