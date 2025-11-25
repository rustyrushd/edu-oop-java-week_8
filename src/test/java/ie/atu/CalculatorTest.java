package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calc;

    @BeforeEach
    public void setup() {
        calc = new Calculator();
    }

    @Test
    public void testAdd_Success() {
        assertEquals(10, calc.add(4, 6));
    }

    @Test
    public void testAdd_Failure() {
        Exception ex = assertThrows(ArithmeticException.class, ()-> calc.add(Integer.MAX_VALUE, 1));
        assertEquals("integer overflow", ex.getMessage());
    }
}
