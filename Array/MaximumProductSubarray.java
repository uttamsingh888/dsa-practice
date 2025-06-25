/*
 * MEDIUM
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 *Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        //        int[] nums = {2, -3, 0,-6, -4};
        //        int[] nums = {2, 3, 0, 7, 96, 0, 6, 2, 88};
        // 2 pass helps give solution to all -ve numbers present odd times
        //        int[] nums = {-1, -2, -3};
        //        int[] nums = {-1, -3, -10, -2};
        int[] nums = {-2, 0, -1};
        int maximumProductSubarray = 0;
        int maximumProductSubarrayPass1 = Integer.MIN_VALUE;
        int maximumProductSubarrayPass2 = Integer.MIN_VALUE;
        int productPass1 = 1, productPass2 = 1;
        int arrLength = nums.length;
        for (int i = 0; i < arrLength; i++) {
            // pass1
            productPass1 *= nums[i];
            if (productPass1 > maximumProductSubarrayPass1) {
                maximumProductSubarrayPass1 = productPass1;
            }
            if (nums[i] == 0) {
                productPass1 = 1;
            }

            // pass2
            productPass2 *= nums[arrLength - i - 1];
            if (productPass2 > maximumProductSubarrayPass2) {
                maximumProductSubarrayPass2 = productPass2;
            }
            if (nums[arrLength - i - 1] == 0) {
                productPass2 = 1;
            }
        }
        if (maximumProductSubarrayPass2 > maximumProductSubarrayPass1) {
            maximumProductSubarray = maximumProductSubarrayPass2;
        } else {
            maximumProductSubarray = maximumProductSubarrayPass1;
        }
        System.out.println(maximumProductSubarray);
    }
}