package sorting;

import java.util.Arrays;

//stable sort
//inplace
//Tc BestCase:O(N) WorstCase:O(N^2) AverageCase:O(N^2)  (n-1)+(n-2)+(n-3)------+1 =n(n-1)/2 ==n^2
public class BubbleSort {
public static void main(String[] args) {
    int[] arr={90,80,70,60,40};
    bubbleSort(arr);
    
        System.out.print(Arrays.toString(arr));
    
}
static void bubbleSort(int[] arr){
    int n=arr.length;
   
    for(int i=0;i<n-1;i++){
      boolean swapped=false;
        for(int j=0;j<n-i-1;j++){
          //  System.out.println("innerloop");
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                swapped=true;
            }
        }
        if(!swapped){
            break;
        }
    }
}
}
