package think;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberWritingTest {

    @Test
    public void validateNumber() {
        assertEquals(123, NumberWriting.write("123"));
        assertEquals(1239, NumberWriting.write("1239"));
        assertEquals(12348, NumberWriting.write("12348"));
    }
}