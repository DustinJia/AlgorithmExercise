package LintCode;

// http://www.lintcode.com/en/problem/two-sum-data-structure-design/

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */

/**
 * Example
 * add(1); add(3); add(5);
 * find(4) // return true
 * find(7) // return false
 */

import java.util.HashMap;

public class TwoSum_DataStructureDesign_607 {

    private HashMap<Integer, Integer> hashMap = new HashMap();

    public void add(int number) {
        int frequency = hashMap.get(number) == null ? 0 : hashMap.get(number);

        if (frequency == 0) {
            hashMap.put(number, 1);
        } else {
            hashMap.put(number, frequency + 1);
        }
    }

    public boolean find(int value) {
        for (int num1 : hashMap.keySet()) {
            int num2 = value - num1;
            int frequency = hashMap.get(num2) == null ? 0 : hashMap.get(num2);

            if (frequency > 0) {
                if (num1 != num2 || num1 == num2 && frequency > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
