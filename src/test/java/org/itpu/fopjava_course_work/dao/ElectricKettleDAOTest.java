package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.ElectricKettleSearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.ElectricKettle;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ElectricKettleDAOTest {
    @Test
    void shouldFindBy() {
        ElectricKettleDAO dao = new ElectricKettleDAO();

        ElectricKettleSearchCriteria dryerSearchCriteria = new ElectricKettleSearchCriteria();
        dryerSearchCriteria.add(ElectricKettle.class, new FieldValidator("material", "Glass"));

        Iterable<ElectricKettle> iterable = dao.find(dryerSearchCriteria);

        assertNotNull(iterable);
        ElectricKettle[] electricKettles = toArray(iterable, ElectricKettle[]::new);
        assertEquals(2, electricKettles.length);
    }

    @Test
    void shouldGetAll() {
        ElectricKettleDAO dao = new ElectricKettleDAO();

        ElectricKettleSearchCriteria dryerSearchCriteria = new ElectricKettleSearchCriteria();

        Iterable<ElectricKettle> iterable = dao.find(dryerSearchCriteria);

        assertNotNull(iterable);
        ElectricKettle[] electricKettles = toArray(iterable, ElectricKettle[]::new);
        assertEquals(10, electricKettles.length);
    }

    private <A extends Appliance<A>> A[] toArray(Iterable<A> iterable, IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingLong(Appliance::getPrice));
        return arr;
    }
}
