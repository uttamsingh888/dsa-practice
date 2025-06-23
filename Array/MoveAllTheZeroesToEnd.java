/*
 * 283. Move Zeroes (Easy)
 * https://leetcode.com/problems/move-zeroes/
 * Given an integer array nums, move all 0's to the end of it,
 * while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 * */
public class MoveAllTheZeroesToEnd {

    public static void main(String args[]) {
        int arr1[] = {0, 1, 5, 0, 1, 1, 5, 0};
        int arr2[] = {0, 0, 0, 0, 0, 0, 1, 5};
        int arr3[] = {0, 1, 5, 0, 1, 1, 5, 0};
        int arr4[] = {0, 0, 5, 0, 1, 0, 2, 5, 0};
        int arr5[] = {0, 0, 5, 0, 1, 0, 2, 5, 0};

        bruteForce(arr1);
        extraSpace(arr2);
        twoPointerWhile(arr3);
        twoPointerFor(arr4);
        replaceZero(arr5);
    }

    private static void replaceZero(int[] nums) {
        int indexCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[indexCount] = nums[i];
                indexCount++;
            }
        }
        for (int i = indexCount; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.print("\nreplaceZero: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void twoPointerFor(int[] nums) {
        int indexPointer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && indexPointer >= 0 && indexPointer != i) {
                nums[indexPointer] = nums[i];
                nums[i] = 0;
                indexPointer++;
            } else if (nums[i] == 0 && indexPointer == -1) {
                indexPointer = i;
            }
        }

        System.out.print("\nTwoPointerFor: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void twoPointerWhile(int[] nums) {
        int indexPointer1 = 0;
        int indexPointer2 = 1;

        while (indexPointer2 < nums.length) {
            if (nums[indexPointer1] == 0) {
                if (nums[indexPointer2] != 0) {
                    // swap
                    int temp = nums[indexPointer1];
                    nums[indexPointer1] = nums[indexPointer2];
                    nums[indexPointer2] = temp;
                    indexPointer1++;
                }
                indexPointer2++;
            } else {
                indexPointer1++;
                if (indexPointer2 <= indexPointer1) {
                    indexPointer2 = indexPointer1 + 1;
                }
            }
        }

        System.out.print("\nTwoPointerWhile: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void extraSpace(int[] arr) {
        int[] duplicateArr = new int[arr.length];
        int duplicateArrIndexCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                duplicateArr[duplicateArrIndexCount] = arr[i];
                duplicateArrIndexCount++;
            }
        }

        System.out.print("\nExtraSpace: ");
        for (int i = 0; i < duplicateArr.length; i++) {
            System.out.print(duplicateArr[i] + " ");
        }
    }

    private static void bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                moveElementToEnd(i, arr);
            }
        }
        System.out.print("\nBruteforce: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void moveElementToEnd(int index, int[] arr) {
        int val = arr[index];
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = val;
    }
}