package sorting;

import java.util.Arrays;

//as the name suggets select min or max and swap it to its correct position
//inplace
//not stable
//TC BestCase , WorstCase,AverageCase:O(N^2)
public class Selectionsort {
    public static void main(String[] args) {
        int[] arr = { 90, 80, 70, 60, 40 };
        selectionSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        int minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);

        }
    }
}
