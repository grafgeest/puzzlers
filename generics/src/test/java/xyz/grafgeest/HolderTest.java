package xyz.grafgeest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HolderTest {


    @Test
    void testCreateHolder() {
        Holder<Integer> holder = new Holder<>();
        holder.setValue(10);

        Integer value = holder.getValue();

        assertEquals(new Integer(10), value);
    }
}