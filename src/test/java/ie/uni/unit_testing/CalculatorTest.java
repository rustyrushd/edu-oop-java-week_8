package ie.uni.unit_testing;

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
    Exception ex = assertThrows(ArithmeticException.class, () -> calc.add(Integer.MAX_VALUE, 1));
    assertEquals("integer overflow", ex.getMessage());
  }

  @Test
  public void testSubtract_Success() {
    assertEquals(-2, calc.sub(4, 6));
  }

  @Test
  public void testSubtract_Fail() {
    Exception ex = assertThrows(ArithmeticException.class, () -> calc.sub(Integer.MIN_VALUE, 1));
    assertEquals("integer overflow", ex.getMessage());
  }

  @Test
  public void testMultiply_Success() {
    assertEquals(24, calc.mul(4, 6));
  }

  @Test
  public void testMultiply_Fail() {
    Exception ex = assertThrows(ArithmeticException.class, () -> calc.mul(Integer.MIN_VALUE, -1));
    assertEquals("integer overflow", ex.getMessage());
  }

  @Test
  public void testDivide_Success() {
    assertEquals(2, calc.div(4, 2));
  }

  @Test
  public void testDivide_Fail() {
    Exception ex1 = assertThrows(ArithmeticException.class, () -> calc.div(Integer.MIN_VALUE, -1));
    assertEquals("integer overflow", ex1.getMessage());
    Exception ex2 = assertThrows(ArithmeticException.class, () -> calc.div(Integer.MIN_VALUE, 0));
    assertEquals("/ by zero", ex2.getMessage());
  }
}
