package org.itpu.fopjava_course_work;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.itpu.fopjava_course_work.controller.DispatcherController;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.itpu.fopjava_course_work.service.ServiceFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApplianceWarehouseApp {

    public static void main(String[] args) throws IOException, XmlPullParserException {
        ApplianceService applianceService = ServiceFactory.INSTANCE.getApplianceService();  // Instantiate the ApplianceService
        Map<String, String> parameterConverters = new HashMap<>();  // Create and populate the parameterConverters map
        DispatcherController dispatcher = new DispatcherController(applianceService, parameterConverters);
        dispatcher.listen();
    }
}