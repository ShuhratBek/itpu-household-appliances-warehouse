package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.CoffeeMakerSearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.CoffeeMaker;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CoffeeMakerDAOTest {
    @Test
    void shouldFindBy() {
        CoffeeMakerDAO dao = new CoffeeMakerDAO();

        CoffeeMakerSearchCriteria coffeeMakerSearchCriteria = new CoffeeMakerSearchCriteria();
        coffeeMakerSearchCriteria.add(CoffeeMaker.class, new FieldValidator("powerConsumption", "1450"));

        Iterable<CoffeeMaker> iterable = dao.find(coffeeMakerSearchCriteria);

        assertNotNull(iterable);
        CoffeeMaker[] clothesSteamers = toArray(iterable, CoffeeMaker[]::new);
        assertEquals(3, clothesSteamers.length);
    }

    @Test
    void shouldGetAll() {
        CoffeeMakerDAO dao = new CoffeeMakerDAO();

        CoffeeMakerSearchCriteria coffeeMakerSearchCriteria = new CoffeeMakerSearchCriteria();

        Iterable<CoffeeMaker> iterable = dao.find(coffeeMakerSearchCriteria);

        assertNotNull(iterable);
        CoffeeMaker[] clothesSteamers = toArray(iterable, CoffeeMaker[]::new);
        assertEquals(10, clothesSteamers.length);
    }

    private <A extends Appliance<A>> A[] toArray(Iterable<A> iterable, IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingLong(Appliance::getPrice));
        return arr;
    }
}
