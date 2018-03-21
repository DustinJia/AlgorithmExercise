package LintCode;

// http://www.lintcode.com/en/problem/powx-n/

/**
 * Implement pow(x, n).
 *
 * Notice
 * You don't need to care about the precision of your answer,
 * it's acceptable if the expected answer and your answer 's difference is smaller than 1e-3.
 */

/**
 * Example
 * Pow(2.1, 3) = 9.261
 * Pow(0, 1) = 0
 * Pow(1, 0) = 1
 */


public class Pow_428 {

    public static double myPow(double x, int n) {
        if (Math.abs(x) < 1e-9) return 0;

        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }

        double temp = myPow(x, n / 2);
        temp = temp * temp;
        if (n % 2 == 1) {
            temp = x * temp;
        } else if (n % 2 == -1) {
            temp = (1 / x) * temp;
        }

        return temp;
    }
}
