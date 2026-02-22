package basic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.basic.JUNIT5.Calculator;

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All - Start Testing");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Before Each - New Calculator Created");
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(4, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each - Test Completed");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All - Testing Finished");
    }
}