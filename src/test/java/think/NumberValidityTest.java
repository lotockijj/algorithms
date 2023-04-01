package think;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidityTest {

    @Test
    public void validateNumber() {
        assertTrue(NumberValidity.validateNumber(1762483, 30));
        assertTrue(NumberValidity.validateNumber(176248342, 40));
    }
}