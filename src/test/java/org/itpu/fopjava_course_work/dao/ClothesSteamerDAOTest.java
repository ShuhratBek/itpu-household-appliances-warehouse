package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.ClothesSteamerSearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.ClothesSteamer;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClothesSteamerDAOTest {
    @Test
    void shouldFindBy() {
        ClothesSteamerDAO dao = new ClothesSteamerDAO();

        ClothesSteamerSearchCriteria clothesSteamerSearchCriteria = new ClothesSteamerSearchCriteria();
        clothesSteamerSearchCriteria.add(ClothesSteamer.class, new FieldValidator("powerConsumption", "1200"));

        Iterable<ClothesSteamer> iterable = dao.find(clothesSteamerSearchCriteria);

        assertNotNull(iterable);
        ClothesSteamer[] clothesSteamers = toArray(iterable, ClothesSteamer[]::new);
        assertEquals(1, clothesSteamers.length);
    }

    @Test
    void shouldGetAll() {
        ClothesSteamerDAO dao = new ClothesSteamerDAO();

        ClothesSteamerSearchCriteria clothesSteamerSearchCriteria = new ClothesSteamerSearchCriteria();

        Iterable<ClothesSteamer> iterable = dao.find(clothesSteamerSearchCriteria);

        assertNotNull(iterable);
        ClothesSteamer[] clothesSteamers = toArray(iterable, ClothesSteamer[]::new);
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
