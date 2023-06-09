package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.AirConditionerSearchCriteria;
import org.itpu.fopjava_course_work.entity.AirConditioner;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AirConditionerDAOTest {
    @Test
    void shouldFindBy() {
        AirConditionerDAO dao = new AirConditionerDAO();

        AirConditionerSearchCriteria airConditionerSearchCriteria = new AirConditionerSearchCriteria();
        airConditionerSearchCriteria.add(AirConditioner.class, new FieldValidator("coolingCapacity", "8000"));

        Iterable<AirConditioner> iterable = dao.find(airConditionerSearchCriteria);

        assertNotNull(iterable);
        AirConditioner[] airConditioners = toArray(iterable, AirConditioner[]::new);
        assertEquals(1, airConditioners.length);
    }

    @Test
    void shouldGetAll() {
        AirConditionerDAO dao = new AirConditionerDAO();

        AirConditionerSearchCriteria AirConditionerSearchCriteria = new AirConditionerSearchCriteria();

        Iterable<AirConditioner> iterable = dao.find(AirConditionerSearchCriteria);

        assertNotNull(iterable);
        AirConditioner[] AirConditioners = toArray(iterable, AirConditioner[]::new);
        assertEquals(10, AirConditioners.length);
    }

    private <A extends Appliance<A>> A[] toArray(Iterable<A> iterable, IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingLong(Appliance::getPrice));
        return arr;
    }
}
