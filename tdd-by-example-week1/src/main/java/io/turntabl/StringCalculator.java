package io.turntabl;

import java.util.Arrays;

public class StringCalculator {

    private StringCalculator() {}

    public static int add(String s) {
        if(s == null || s.isBlank()) return 0;
        String[] numbers = s.split(",");

        return Arrays
                .stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
