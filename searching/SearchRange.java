package searching;

public class SearchRange {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int target=7;
        int[] ans=searchRange(arr,target);
        System.out.println("{"+ans[0]+","+ans[1]+"}");
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        int start_index=search(nums,target,true);
        int end_index=search(nums,target,false);

        ans[0]=start_index;
        ans[1]=end_index;
        return ans;
    }
    static int search(int[] nums,int target,boolean firstValue){
        int s=0;
        int e=nums.length-1;
        int ans=-1;
        while(s<=e){
            int m=(s+e)/2;
            if(target<nums[m]){
                e=m-1;
            }
            else if(target>nums[m]){
                s=m+1;
            }
            else {
                ans=m;
                if(firstValue==true){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return ans;
    }
}
