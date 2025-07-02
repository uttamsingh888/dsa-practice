/*
 * 41. First Missing Positive (HARD)
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * 
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * 
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * 
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * 
 */
import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int number1 = sortedSetApproach(nums);    
        int number2 = newApproach(nums);
        System.out.println(number1);
        System.out.println(number2);
    }

    private static int newApproach(int[] nums) {
        boolean [] visitedArr = new boolean[nums.length];
       for (int i=0; i<nums.length; i++ ) {
        if(nums[i] > 0 && nums[i] <= nums.length) {
            visitedArr[nums[i]-1] = true; 
        }
       }

       for(int i=0;i<visitedArr.length;i++) {
        System.out.print(visitedArr[i]+ " ");
        if (visitedArr[i] == false) {
            return i+1;
        }
       }
       return 0;
    }

    private static int sortedSetApproach(int[] nums) {
        Set<Integer> sortedSet = new TreeSet<>();;

        for(int i=0;i<nums.length; i++) {
            if (nums[i] > 0) {
                sortedSet.add(nums[i]);
            }
        }

        int count = 1;

        for (Integer val : sortedSet) {
            if (count!=val) {
                System.out.println(count);
                break;
            }
            count++;
        }
        return count;
    }
}