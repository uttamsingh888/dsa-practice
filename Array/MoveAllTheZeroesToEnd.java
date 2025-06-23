/*
* 283. Move Zeroes (Easy)
*
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
        twoPointer(arr2);
        bruteForce(arr1);
        extraSpace(arr3);
    }

    private static void twoPointer(int[] arr) {
        int indexPointer1 = 0;
        int indexPointer2 = 1;

        while(indexPointer2 != arr.length) {
            if(arr[indexPointer1] == 0) {
                if(arr[indexPointer2] != 0) {
                    //swap
                    int temp = arr[indexPointer2];
                    arr[indexPointer2] = arr[indexPointer1];
                    arr[indexPointer1] = temp;
                    indexPointer1++;
                }
                indexPointer2++;
            }
        }

        System.out.println("Two Pointer:");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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

        System.out.println("Extra Space:");
        for (int i = 0; i < duplicateArr.length; i++) {
            System.out.print(duplicateArr[i]+ " ");
        }
    }

    private static void bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                moveElementToEnd(i, arr);
            }
        }
        System.out.println("Bruteforce:");
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