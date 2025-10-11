import java.util.*;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // 합이 target이상인 부분합 최소 길이 구하기. 
        // sum >tagert이면 앞 줄이고, sum<target이면 뒤를 줄여서 구하기?

        int min=nums.length+1;
        int start=0;
        int end=0;
        long sum =0;
        while(start<=end && end<nums.length){
            sum+=nums[end];
            
            while( sum>=target){
                //최솟값 갱신 
                min=Math.min(end-start+1, min);
                sum-=nums[start++];
            }
            //다음 이동 
            end++; //end 는 0-> 

        }

        if(min ==  nums.length+1) return 0;
        
        return min;

        
    }
}