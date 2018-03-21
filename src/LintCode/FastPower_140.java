package LintCode;

// http://www.lintcode.com/en/problem/fast-power/

/**
 * Calculate the a^n % b where a, b and n are all 32bit integers.
 */

/**
 * Example
 * For 2^31 % 3 = 2
 * For 100^1000 % 1000 = 0
 */


public class FastPower_140 {

    public int fastPower(int a, int b, int n) {
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }

        long temp = fastPower(a, b, n / 2);

        long result = (temp * temp) % b;
        if (n % 2 == 1) {
            result = (a * result) % b;
        }

        return (int)result;
    }

}

// Note:
// 1. (a * b) % p = ((a % p) * (b % p)) % p
// 2. Store temp with long, otherwise may get wrong result
