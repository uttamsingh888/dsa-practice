package org.example;

/*
https://www.geeksforgeeks.org/dsa/find-second-largest-element-array/

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.

Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.

Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 there is no second largest element.
 */

public class SecondLargestElement {
    public static void main(String[] args) {
        int arr1[] = {12, 35, 1, 10, 34, 1};
        int arr2[] = {10, 5, 10};
        int arr3[] = {10, 10, 10};
        secondLargestElement(arr3);
    }

    private static void secondLargestElement(int[] arr) {
        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargestElement) {
                if (arr[i] > largestElement) {
                    largestElement = arr[i];
                } else if (arr[i] == largestElement) {
                    //do nothing
                } else {
                    secondLargestElement = arr[i];
                }
            }
        }
        secondLargestElement = secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement;
        System.out.println(secondLargestElement);
    }
}
