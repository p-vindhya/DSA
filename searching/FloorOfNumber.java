package searching;
public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {5, 9, 11, 28, 41, 77, 89, 90 };
        int target = 42;
        int ans = floor(arr, target);
        System.out.println(ans);
    }
    //return index of greatest number <=target
    static int floor(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;
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
        return end;
    }
}
