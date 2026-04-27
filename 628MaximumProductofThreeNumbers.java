/*
628. Maximum Product of Three Numbers
Easy
https://leetcode.com/problems/maximum-product-of-three-numbers/description/


Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6

Example 2:
Input: nums = [1,2,3,4]
Output: 24

Example 3:
Input: nums = [-1,-2,-3]
Output: -6

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
*/

class MaximumProductofThreeNumbers {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3};
        int arr2[] = {1, 2, 3, 4};
        int arr3[] = {-1, -2, -3};
        System.out.println("Maximum Product of Three Numbers: " + maximumProduct(arr1));
        System.out.println("Maximum Product of Three Numbers: " + maximumProduct(arr2));
        System.out.println("Maximum Product of Three Numbers: " + maximumProduct(arr3));
    }

    private static int maximumProduct(int[] nums) {
            int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {

            if(nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            } 
            
            if (nums [i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums [i] < secondMin) {
                secondMin = nums[i];
            }

        }

        System.out.println("firstMax "+firstMax);
        System.out.println("secondMax "+secondMax);
        System.out.println("thirdMax "+thirdMax);
        System.out.println("firstMin "+firstMin);
        System.out.println("secondMin "+secondMin);

        int maxMultiplication = firstMax * secondMax * thirdMax;
        int minMultiplicationAndMax = firstMin * secondMin * firstMax;

       return Math.max(maxMultiplication, minMultiplicationAndMax);

    }
}