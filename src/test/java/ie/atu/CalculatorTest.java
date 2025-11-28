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
    public void add_NoOverflow_ReturnsSum() {
        assertEquals(10, calc.add(4, 6));
    }

    @Test
    public void add_Overflow_ThrowsException() {
        Exception ex = assertThrows(ArithmeticException.class, () -> calc.add(Integer.MAX_VALUE, 1));
        assertEquals("integer overflow", ex.getMessage());
    }

    @Test
    public void subtract_NoOverflow_ReturnsDifference() {
        assertEquals(-2, calc.sub(4, 6));
    }

    @Test
    public void subtract_Overflow_ThrowsException() {
        Exception ex = assertThrows(ArithmeticException.class, () -> calc.sub(Integer.MIN_VALUE, 1));
        assertEquals("integer overflow", ex.getMessage());
    }

    @Test
    public void multiply_NoOverflow_ReturnsMultiplication() {
        assertEquals(24, calc.mul(4, 6));
    }

    @Test
    public void multiply_Overflow_ThrowsException() {
        Exception ex = assertThrows(ArithmeticException.class, () -> calc.mul(Integer.MIN_VALUE, -1));
        assertEquals("integer overflow", ex.getMessage());
    }

    @Test
    public void divide_NoOverflow_ReturnsDivision() {
        assertEquals(2, calc.div(4, 2));
    }

    @Test
    public void divide_Overflow_ThrowsException() {
        Exception ex = assertThrows(ArithmeticException.class, () -> calc.div(Integer.MIN_VALUE, -1));
        assertEquals("integer overflow", ex.getMessage());
    }

    @Test
    public void divide_byZero_ThrowsException() {
        Exception ex = assertThrows(ArithmeticException.class, () -> calc.div(Integer.MIN_VALUE, 0));
        assertEquals("/ by zero", ex.getMessage());
    }
}
