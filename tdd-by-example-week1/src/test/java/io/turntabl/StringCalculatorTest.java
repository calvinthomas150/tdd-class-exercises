package io.turntabl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    @DisplayName("When there are no arguments zero should be returned")
    void testAddNoArguments() {
        Assertions.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    @DisplayName("When there is one argument that should be returned")
    void testAddOneArgument() {
        Assertions.assertEquals(5, StringCalculator.add("5"));
    }

    @Test
    @DisplayName("When there is one argument that is greater than 9 it should be returned")
    void testAddOneArgumentLong() {
        Assertions.assertEquals(1000000045, StringCalculator.add("1000000045"));
    }

    @Test
    @DisplayName("When there is null argument passed then should return zero")
    void testNullArgument() {
        Assertions.assertEquals(0, StringCalculator.add(null));
    }

    @Test
    @DisplayName("When there is null argument passed then should return zero")
    void testBlankArgument() {
        Assertions.assertEquals(0, StringCalculator.add(" "));
    }

    @Test
    @DisplayName("When there is a non number provided then we should throw an exception")
    void testNonNumberArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("s"));
    }

    @Test
    @DisplayName("When there is only one number but it is greater than Integer.MaxValue then throw an exception")
    void testNumberTooLarge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("23455678789754354"));
    }

    @Test
    @DisplayName("When I have two numbers separated by a comma then the sum of the two numbers should be returned")
    void testAddingTwoNumbers() {
        Assertions.assertEquals(7, StringCalculator.add("3,4"));
    }

    @Test
    @DisplayName("When I have three numbers separated by a comma then the sum of the three numbers should be returned")
    void testAddingThreeNumbers() {
        Assertions.assertEquals(12, StringCalculator.add("3,4,5"));
    }

}
