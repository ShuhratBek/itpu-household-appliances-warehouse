package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.DishwasherSearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.Dishwasher;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DishwasherDAOTest {
    @Test
    void shouldFindBy() {
        DishwasherDAO dao = new DishwasherDAO();

        DishwasherSearchCriteria dishwasherSearchCriteria = new DishwasherSearchCriteria();
        dishwasherSearchCriteria.add(Dishwasher.class, new FieldValidator("placeSettings", "12"));

        Iterable<Dishwasher> iterable = dao.find(dishwasherSearchCriteria);

        assertNotNull(iterable);
        Dishwasher[] dishwashers = toArray(iterable, Dishwasher[]::new);
        assertEquals(2, dishwashers.length);
    }

    @Test
    void shouldGetAll() {
        DishwasherDAO dao = new DishwasherDAO();

        DishwasherSearchCriteria dishwasherSearchCriteria = new DishwasherSearchCriteria();

        Iterable<Dishwasher> iterable = dao.find(dishwasherSearchCriteria);

        assertNotNull(iterable);
        Dishwasher[] dishwashers = toArray(iterable, Dishwasher[]::new);
        assertEquals(10, dishwashers.length);
    }

    private <A extends Appliance<A>> A[] toArray(Iterable<A> iterable, IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingLong(Appliance::getPrice));
        return arr;
    }
}
