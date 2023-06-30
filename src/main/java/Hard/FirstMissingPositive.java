package Hard;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        var testCase1 = new int[]{1, 2, 0};
        var testCase2 = new int[]{3, 4, -1, 1};
        var testCase3 = new int[]{-1, 4, 2, 1, 9, 10};
        System.out.println("Naive approach case1, [expected: 3], result:" + firstMissingPositive_Naive(testCase1));
        System.out.println("Naive approach case2, [expected: 2], result:" + firstMissingPositive_Naive(testCase2));
        System.out.println("Naive approach case3, [expected: 2], result:" + firstMissingPositive_Naive(testCase3));

        System.out.println("Improved approach case1, [expected: 3], result:" + firstMissingPositive_Improved(testCase1));
        System.out.println("Improved approach case2, [expected: 2], result:" + firstMissingPositive_Improved(testCase2));
        System.out.println("Improved approach case3, [expected: 2], result:" + firstMissingPositive_Improved(testCase3));

        System.out.println("Optimized approach case1, [expected: 3], result:" + firstMissingPositive_Optimized(testCase1));
        System.out.println("Optimized approach case2, [expected: 2], result:" + firstMissingPositive_Optimized(testCase2));
        System.out.println("Optimized approach case3, [expected: 2], result:" + firstMissingPositive_Optimized(testCase3));
    }

    /**
     * Naive approach, better space efficiency
     */
    public static int firstMissingPositive_Naive(int[] nums) {
        var s = Arrays.stream(nums)
                .filter(i -> i > 0)
                .distinct()
                .sorted()
                .toArray();
        if (s.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= s.length) return i + 1;
            if (i + 1 != s[i]) return i + 1;
        }
        return nums.length + 1;
    }

    // Improved time efficiency, middle space efficiency
    public static int firstMissingPositive_Improved(int[] nums) {
        Arrays.sort(nums);
        var minimun = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minimun) {
                minimun++;
            }

        }
        return minimun;
    }

    // Optimized time efficiency, middle space efficiency
    public static int firstMissingPositive_Optimized(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            var comp = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[comp]) {
                int temp = nums[i];
                nums[i] = nums[comp];
                nums[comp] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;
    }
}
