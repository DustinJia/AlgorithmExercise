package Templates;

/**
 * Created by dustin.jia on 3/20/18.
 */
public class BinarySearch {

    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {  // 1. start + 1 < end
            int mid = start + (end - start) / 2;  // 2. start + (end - start) / 2
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid;  // 3. mid NOT +1 / -1
            } else {
                end = mid;
            }
        }

        // 4. Handle start and end individually
        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }

        return -1;
    }
}
