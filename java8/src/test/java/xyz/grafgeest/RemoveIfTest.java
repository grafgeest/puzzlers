package xyz.grafgeest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RemoveIfTest {
    @Test
    void testRemoveIf() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(toList());
        list.removeIf(o -> (o % 2 == 0));
        assertEquals(list, Arrays.asList(1, 3, 5));
    }
}