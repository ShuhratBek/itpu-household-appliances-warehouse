package org.itpu.fopjava_course_work.service;

import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.dao.ApplianceDAO;
import org.itpu.fopjava_course_work.dao.DaoFactory;
import org.itpu.fopjava_course_work.entity.Appliance;

import java.util.Collection;
import java.util.Collections;

public enum ServiceFactory {
    INSTANCE;

    public ApplianceService getApplianceService() {
        return new ApplianceService() {
            @Override
            public <T extends Appliance<T>> Collection<T> find(SearchCriteria<T> criteria) {
                ApplianceDAO<T> dao = DaoFactory.INSTANCE.getApplianceDAO(criteria.getApplianceType());
                if (dao == null) {
                    return Collections.emptyList();
                }

                return dao.find(criteria);
            }
        };
    }
}
