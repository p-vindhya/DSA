package searching;
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] letters= { 'c','f','j' };
        char target='j';
        char ans=nextGreatestLetter(letters,target);
        System.out.println(ans);
    }
    //744--Leetcode
    // check here equal to target is not present
    // its a ceiling problem
    // if target is the greatest char in the array return first element
    static char nextGreatestLetter(char[] letters, char target) {
        int start_index=0;
        int end_index=letters.length-1;
       
         while(start_index<=end_index){
            int mid_index=(start_index+end_index)/2;
            if(target<letters[mid_index]){
            end_index=mid_index-1;
            }
            else if(target>=letters[mid_index]){
                start_index=mid_index+1;
            }
         }
         return start_index==letters.length?letters[0] : letters[start_index];
    }
}
