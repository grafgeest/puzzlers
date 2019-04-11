import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringInternTest {
    private static final String test1 = new String("test").intern();
    private static final String test2 = new String("test").intern();
    private static final String test3 = new String("test");
    private static final String test4 = new String("test");
    private static final String test5 = "test";

    @Test
    void testIntern(){
        assertEquals(test1, test2);
        assertEquals(test3, test4);
        assertEquals(test1, test3);
        assertSame(test1, test2);
        assertNotSame(test3, test4);
        assertNotSame(test1, test3);
        assertSame(test1, test5);
        assertNotSame(test3, test5);
    }
}
