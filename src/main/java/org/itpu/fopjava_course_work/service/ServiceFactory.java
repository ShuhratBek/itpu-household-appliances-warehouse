package org.itpu.fopjava_course_work.service;

import org.itpu.fopjava_course_work.dao.DaoFactory;
import org.itpu.fopjava_course_work.criteria.SearchCriteria;
import org.itpu.fopjava_course_work.dao.ApplianceDAO;
import org.itpu.fopjava_course_work.entity.Appliance;

import java.util.Collection;
import java.util.Collections;

public enum ServiceFactory {
    INSTANCE;

    public ApplianceService getApplianceService() {
        return new ApplianceService() {
            @Override
            public <A extends Appliance<A>> Collection<A> find(SearchCriteria<A> criteria) {
                ApplianceDAO<A> dao = DaoFactory.INSTANCE.getApplianceDAO(criteria.getApplianceType());
                if (dao == null) {
                    // Handle the case when the 'dao' object is null (e.g., throw an exception or return an empty collection)
                    // Example: throw new IllegalStateException("DAO is not available for the given criteria");
                    return Collections.emptyList();
                }

                return dao.find(criteria);
            }
        };
    }
}
