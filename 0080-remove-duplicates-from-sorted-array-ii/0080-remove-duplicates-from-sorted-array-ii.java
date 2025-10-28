class Solution {
    public int removeDuplicates(int[] nums) {

        //최대 2번 등장
        int k=1;
        int cnt=1;

        for(int i=1;i<nums.length;i++){

            //이전과 동일 케이스
            if( nums[i] ==nums[i-1]){
                nums[k]=nums[i];
                if(cnt<2){
                    k++;
                }
                else{
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