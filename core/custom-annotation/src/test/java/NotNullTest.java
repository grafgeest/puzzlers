import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static xyz.grafgeest.NotNull.test;

class NotNullTest {
    @Test
    void testNotNull() {
        assertThrows(NullPointerException.class,
                () -> {
                    test(null);
                });
    }
}