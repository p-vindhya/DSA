package searching;

 class PeakElement {
    public static void main(String[] args) {
        int[] a = {1,7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6};

        System.out.println(findPeakValue(a, 0, a.length-1));
    }

    
    private static int findPeakValue(int[] arr, int start, int end) {
      int  left=start;
        int right=end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // Strictly ascending: peak is to the right
                left = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                // Strictly descending: peak is to the left
                right = mid;
            } else {
                
                int i = mid;
                while (i < right && arr[i] == arr[i + 1]) {
                    i++;
                }
                if (i == right || arr[i] > arr[i + 1]) {
                    // Plateau ends in descent; peak is in left half
                    right = mid;
                } else {
                    // Plateau ends in ascent; peak is in right half
                    left = i + 1;
                }
            }
        }
        return arr[left];
    }

}
