package searching;
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 9, 11, 28, 41, 77, 89, 90 };
        int target = 28;
        int ans = binarySearch(arr, target);
        System.out.println(ans);

    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else if (target == arr[mid]) {
                return mid;
            }
        }

        return -1;
    }

}
