package LintCode;

// https://www.lintcode.com/problem/next-closest-time/description

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
 * "1:34", "12:9" are all invalid.
 */

/**
 * Example
 *
 * Given time = "19:34", return "19:39".
 * Explanation:
 * The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 *
 * Given time = "23:59", return "22:22".
 * Explanation:
 * The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 * It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NextClosestTime_862 {

    int minDifference = Integer.MAX_VALUE;
    String result = "";

    public String nextClosestTime(String time) {
        // Get numbers from time string
        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(Integer.parseInt(time.substring(0, 1)));
        numbers.add(Integer.parseInt(time.substring(1, 2)));
        numbers.add(Integer.parseInt(time.substring(3, 4)));
        numbers.add(Integer.parseInt(time.substring(4, 5)));

        if (numbers.size() == 1) {  // Only one option, no next time. e.g., 11:11
            return time;
        }

        int targetMinutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        dfs(new ArrayList<Integer>(numbers), 0, new ArrayList<Integer>(), targetMinutes);

        return result;
    }

    private void dfs(ArrayList<Integer> numbers, int startIndex, ArrayList<Integer> digits, int targetMinutes) {
        if (digits.size() == 4) {
            int hours = digits.get(0) * 10 + digits.get(1);
            int minutes = digits.get(2) * 10 + digits.get(3);
            int equivalentMinutes = hours * 60 + minutes;

            // Invalid permutation
            if (equivalentMinutes == targetMinutes) {
                return;
            }

            int diffMinutes = equivalentMinutes - targetMinutes < 0 ?
                              equivalentMinutes - targetMinutes + 24 * 60 :
                              equivalentMinutes - targetMinutes;
            if (diffMinutes < minDifference) {
                result = constructTimeString(digits);
                minDifference = diffMinutes;
            }

            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (!isValid(digits, number, startIndex)) {
                continue;
            }

            ArrayList<Integer> newDigits = new ArrayList<>(digits);
            newDigits.add(number);
            dfs(numbers, startIndex + 1, newDigits, targetMinutes);
        }
    }

    private boolean isValid(ArrayList<Integer> digits, int number, int position) {
        switch (position) {
            case 0:
                return number < 3;
            case 1:
                int hours = digits.size() > 0 ? digits.get(0) * 10 + number : number;
                return hours < 25;
            case 2:
                return number < 6;
            case 3:
                return number < 10;
        }

        return false;
    }

    private String constructTimeString(ArrayList<Integer> digits) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(digits.get(0).toString());
        stringBuilder.append(digits.get(1).toString());
        stringBuilder.append(":");
        stringBuilder.append(digits.get(2).toString());
        stringBuilder.append(digits.get(3).toString());

        return stringBuilder.toString();
    }
}
