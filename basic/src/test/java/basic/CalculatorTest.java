package basic;

import org.junit.jupiter.api.*;

import com.basic.JUNIT5.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @Tag("fast")
    void testAddition() {
        assertEquals(5, calculator.add(2,3),
                () -> "Addition failed");
    }

    @Test
    @Tag("slow")
    void testDivision() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @RepeatedTest(3)
    void repeatedTestExample() {
        assertTrue(calculator.add(1,1) == 2);
    }
}