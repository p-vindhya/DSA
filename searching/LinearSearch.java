package searching;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 9, 11, 28, 41, 77, 89, 90 };
        int target = 28;
        int ans = linearSearch(arr, target);
        System.out.println(ans);
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
