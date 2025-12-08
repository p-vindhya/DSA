package searching;

import java.util.Arrays;

public class RowColSortedMatrix {
    public static void main(String[] args) {
        int[][] arr={
            {10,20,30,40,50},
            {15,25,35,45,55},
            {28,29,37,48,60}
        };
        System.out.print(Arrays.toString(rowCol(arr,48)));
    }
   


 static int[] rowCol(int[][] arr,int target){
    int r=0;
    int c=arr[0].length-1;
    while(r<arr.length && c>=0){
        if(arr[r][c]==target){
        return new int[]{r,c};
        }
        else if(arr[r][c]<target){
            r++;
        }
        else{
            c--;
        }
    }
    return new int[]{-1,-1};
 }
}