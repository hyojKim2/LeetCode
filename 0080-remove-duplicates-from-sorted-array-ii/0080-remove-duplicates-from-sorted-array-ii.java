class Solution {
    public int removeDuplicates(int[] nums) {

        //최대 2번 등장
        int k=1;
        int cnt=1;

        for(int i=1;i<nums.length;i++){

            if( nums[i] ==nums[i-1]){
                nums[k]=nums[i];
                if(cnt<2){ //k움직여줌.
                    k++;
                }
                cnt++;
            }
            
            else if(  (nums[i]!=nums[i-1] )){
                nums[k]=nums[i];
                cnt=1; 
                k++;
            }

        }

        return k;
        
    }
}