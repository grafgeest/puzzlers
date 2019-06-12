package xyz.grafgeest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CatchThrowsTest {

    private CatchThrows catchThrows;

    @BeforeEach
    void setUp() {
        catchThrows = new CatchThrows();
    }

    @org.junit.jupiter.api.Test
    void test() {
        assertEquals("finally", catchThrows.test());
    }

    @org.junit.jupiter.api.Test()
    void test2() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            catchThrows.test2();
        });
    }
}
