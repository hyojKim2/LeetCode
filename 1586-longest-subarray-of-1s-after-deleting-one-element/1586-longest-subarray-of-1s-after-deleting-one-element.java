class Solution {
    public int longestSubarray(int[] nums) {

        //원소 하나가 사라질 때 가장 긴 1 subAraay

        int start=0;
        int end=0;
        int max=0;
        int zero=0;
        int anyZero=0;
        int zeroIdx=0;

        // 슬라이딩 도어를 이동. 

        while(end< nums.length){

            if(nums[end]==0){
                zero++;
            }
            end++;
            if(zero>1){
                if(nums[start]==0){
                    zero--;
                }
                start++;
            }

            if(max < end-start){
                max=end-start;
            }

        }

        return max-1;

    }
}