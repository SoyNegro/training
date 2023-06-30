package Hard;

import java.util.Arrays;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * <p>
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 */
public class MinimunRotatedSortedArray2 {
    public static void main(String[] args) {
        var testCase1 = new int[]{1, 3, 5};
        var testCase2 = new int[]{2, 2, 2, 0, 1};

        System.out.println("Naive approach case1, [expected: 1], result:" + findMin_Naive(testCase1));
        System.out.println("Naive approach case1, [expected: 0], result:" + findMin_Naive(testCase2));

        System.out.println("Optimized approach case1, [expected: 1], result:" + findMin_Optimized(testCase1));
        System.out.println("Optimized approach case1, [expected: 0], result:" + findMin_Optimized(testCase2));
    }

    // Naive one line approach, easy to read.
    public static int findMin_Naive(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }

    // Optimized, nothing but a Binary Search
    public static int findMin_Optimized(int[] nums) {
            var low=0;
            var high=nums.length-1;
            while(low<high){
                int mid=low+(high-low)/2;
                if(nums[mid]>nums[high]){
                    low=mid+1;
                }else{
                    if(nums[mid]<nums[high]){
                        high=mid;
                    }else{
                        high--;
                    }
                }
            }
            return nums[high];
    }
}
