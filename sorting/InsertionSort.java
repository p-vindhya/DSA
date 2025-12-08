package sorting;

import java.util.Arrays;

//stable sort
//inplace
//Tc BestCase:O(N) WorstCase:O(N^2) AverageCase:O(N^2)  (n-1)+(n-2)+(n-3)------+1 =n(n-1)/2 ==n^2
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 90, 80, 50, 60, 40 };
        insertionSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
