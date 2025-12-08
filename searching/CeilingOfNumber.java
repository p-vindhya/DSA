package searching;
public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 9, 11, 28, 41, 77, 89, 90 };
        int target = 92;
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }
//return smallest number >=target
    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        if(target > arr[end]){
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target == arr[mid]) {
                return mid;

            }
        }
        return start;
    }
}
