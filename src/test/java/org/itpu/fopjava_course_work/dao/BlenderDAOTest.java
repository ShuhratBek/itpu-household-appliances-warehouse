package org.itpu.fopjava_course_work.dao;

import org.itpu.fopjava_course_work.criteria.BlenderSearchCriteria;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.entity.Blender;
import org.itpu.fopjava_course_work.validators.FieldValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BlenderDAOTest {
    @Test
    void shouldFindBy() {
        BlenderDAO dao = new BlenderDAO();

        BlenderSearchCriteria blenderSearchCriteria = new BlenderSearchCriteria();
        blenderSearchCriteria.add(Blender.class, new FieldValidator("powerConsumption", "1200"));

        Iterable<Blender> iterable = dao.find(blenderSearchCriteria);

        assertNotNull(iterable);
        Blender[] blenders = toArray(iterable, Blender[]::new);
        assertEquals(1, blenders.length);
    }

    @Test
    void shouldGetAll() {
        BlenderDAO dao = new BlenderDAO();

        BlenderSearchCriteria blenderSearchCriteria = new BlenderSearchCriteria();

        Iterable<Blender> iterable = dao.find(blenderSearchCriteria);

        assertNotNull(iterable);
        Blender[] blenders = toArray(iterable, Blender[]::new);
        assertEquals(10, blenders.length);
    }

    private <A extends Appliance<A>> A[] toArray(Iterable<A> iterable, IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingLong(Appliance::getPrice));
        return arr;
    }
}
