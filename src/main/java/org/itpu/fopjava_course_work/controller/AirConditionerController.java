package org.itpu.fopjava_course_work.controller;

import org.itpu.fopjava_course_work.converter.ParameterConverter;
import org.itpu.fopjava_course_work.converter.RawConverters;
import org.itpu.fopjava_course_work.criteria.AirConditionerSearchCriteria;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.parameter.Parameter;
import org.itpu.fopjava_course_work.entity.AirConditioner;
import org.itpu.fopjava_course_work.service.ApplianceService;
import java.util.Collection;
import java.util.Map;

public class AirConditionerController extends ConcreteController<AirConditioner> {
    public AirConditionerController(ApplianceService applianceService) {
        super(applianceService);
    }

    @Override
    protected Collection<AirConditioner> findAll() {
        return applianceService.find(createCriteria());
    }
    @Override
    protected Collection<AirConditioner> find(Map<String, String> searchParameters) {
        AirConditionerSearchCriteria searchCriteria = new AirConditionerSearchCriteria();
        for (Map.Entry<String, String> entry : searchParameters.entrySet()) {
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();

            // Use the RawConverters enum to obtain the appropriate converter based on the attribute name
            RawConverters rawConverter = RawConverters.valueOf(attributeName.toUpperCase());
            ParameterConverter<AirConditioner> converter = rawConverter.generic();

            // Convert the attribute value into a Parameter object using the converter
            Parameter<AirConditioner> parameter = converter.convert(attributeValue);

            // Set the parameter in the search criteria
            searchCriteria.add(parameter);
        }
        return applianceService.find(searchCriteria);
    }

    @Override
    protected SearchCriteria<AirConditioner> createCriteria() {
        return new AirConditionerSearchCriteria();
    }
}