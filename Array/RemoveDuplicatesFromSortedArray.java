/*
 * EASY
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicatesFromSortedArray(nums);
        System.out.println("k " + k);
    }

    private static int removeDuplicatesFromSortedArray(int[] nums) {
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i + 1];
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return index;
    }
}