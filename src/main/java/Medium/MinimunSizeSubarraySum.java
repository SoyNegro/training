package Medium;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * */

public class MinimunSizeSubarraySum {
    public static void main(String[] args) {
        var target1 = 7;
        var nums1 = new int[]{2,3,1,2,4,3};

        var target2 = 11;
        var nums2 = new int[]{1,1,1,1,1,1,1,1};

        System.out.println("Space optimized approach target1-nums1, [expected: 2], result:"+ minSubArrayLen_SpaceOptimized(target1,nums1));
        System.out.println("Space optimized approach target2-nums2, [expected: 0], result:"+ minSubArrayLen_SpaceOptimized(target2,nums2));

        System.out.println("Time optimized approach target1-nums1, [expected: 2], result:"+ minSubArrayLen_TimeOptimized(target1,nums1));
        System.out.println("Time optimized approach target2-nums2, [expected: 0], result:"+ minSubArrayLen_TimeOptimized(target2,nums2));
    }


// Optimized space efficiency
    public static int minSubArrayLen_SpaceOptimized(int target, int[] nums) {
        if (nums.length == 1) {
            if (nums[0] >= target) return 1;
            else return 0;
        }
        int sum, count;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            count = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                count += 1;
                if (sum >= target) break;
            }
            if (sum >= target) min = Math.min(count, min);
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
// Optimized time efficiency
    public static int minSubArrayLen_TimeOptimized(int target, int[] nums) {
        var start = 0;
        var min = Integer.MAX_VALUE;
        var sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min, i + 1 - start);
                sum -= nums[start++];
            }
        }
        return min > nums.length ? 0 : min;
    }
}
