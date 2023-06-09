package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.DryerSearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.Dryer;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DryerDAOTest {
    @Test
    void shouldFindBy() {
        DryerDAO dao = new DryerDAO();

        DryerSearchCriteria dryerSearchCriteria = new DryerSearchCriteria();
        dryerSearchCriteria.add(Dryer.class, new FieldValidator("powerConsumption", "2000"));

        Iterable<Dryer> iterable = dao.find(dryerSearchCriteria);

        assertNotNull(iterable);
        Dryer[] dryers = toArray(iterable, Dryer[]::new);
        assertEquals(1, dryers.length);
    }

    @Test
    void shouldGetAll() {
        DryerDAO dao = new DryerDAO();

        DryerSearchCriteria dryerSearchCriteria = new DryerSearchCriteria();

        Iterable<Dryer> iterable = dao.find(dryerSearchCriteria);

        assertNotNull(iterable);
        Dryer[] dryers = toArray(iterable, Dryer[]::new);
        assertEquals(10, dryers.length);
    }

    private <A extends Appliance<A>> A[] toArray(Iterable<A> iterable, IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingLong(Appliance::getPrice));
        return arr;
    }
}
