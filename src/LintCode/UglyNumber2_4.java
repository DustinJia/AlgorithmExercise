package LintCode;

// https://www.lintcode.com/problem/ugly-number-ii/description

/**
 * Ugly number is a number that only have factors 2, 3 and 5.
 * Design an algorithm to find the nth ugly number.
 * The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 *
 * Note:
 *   Note that 1 is typically treated as an ugly number.
 */

/**
 * Example
 * If n=9, return 10.
 */

import java.util.ArrayList;

public class UglyNumber2_4 {

    public int nthUglyNumber(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i < n; i++) {
            int previous = numbers.get(i - 1);

            while (numbers.get(index2) * 2 <= previous) index2++;
            while (numbers.get(index3) * 3 <= previous) index3++;
            while (numbers.get(index5) * 5 <= previous) index5++;

            int minimum = Math.min(numbers.get(index2) * 2,
                          Math.min(numbers.get(index3) * 3,
                                   numbers.get(index5) * 5));
            numbers.add(minimum);
        }

        return numbers.get(n - 1);
    }
}
