package basic;  
import org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.basic.JUNIT5.Calculator;

public class AdvancedJUnitTest {
/*
    Calculator calc = new Calculator();

    @Test
    void testUsingAssertAll() {

        assertAll("Multiple Checks",
                () -> assertEquals(10, calc.add(5, 5)),
                () -> assertEquals(15, calc.add(10, 5)),
                () -> assertTrue(calc.multiply(2, 3) == 6)
        );
    }

    @Disabled("Waiting for bug fix")
    @Test
    void disabledTest() {
        assertEquals(100, calc.multiply(10, 10));
    }

    @Test
    void testUsingAssumption() {

        assumeTrue(System.getProperty("os.name").contains("Windows"));

        assertEquals(4, 2 + 2);
    }*/
}