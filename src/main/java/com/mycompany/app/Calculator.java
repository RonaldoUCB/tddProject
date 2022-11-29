package com.mycompany.app;

public class Calculator {

    private final int MAX = 1000;

    public String sum(String sums) throws Exception {
        if (sums != null && sums.equals("")) {
            return "0";
        }

        int total = 0;
        String[] numbers = sums.split(",");
        for (int i = 0; i < numbers.length; i++) {
            int s = Integer.parseInt(numbers[i]);
            if (s <= MAX) {
                total = total + Integer.parseInt(numbers[i]);
            }
            if (s < 0) {
                throw new Exception("The number is negative");
            }
        }
        return String.valueOf(total);
    }
}
