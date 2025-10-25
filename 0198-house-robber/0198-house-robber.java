class Solution {
    public int rob(int[] nums) {


        // n번째 집에서 n-2, n-3중 max인 집의 금액과 합침. 
        int size= nums.length;

        if(size==1)return nums[0];
        if(size==2) return Math.max(nums[0], nums[1]);

        int [] sum = new int[size];
        //초기세팅
        sum[0]=nums[0];
        sum[1]=nums[1];
        sum[2]= nums[2]  + sum[0];

        
        int max = Math.max(sum[1], sum[2]);
        if(size==3) return max;

        for(int i=3;i<size;i++){

            sum[i]=nums[i] + Math.max(sum[i-2], sum[i-3]);
            if(sum[i] > max) max=sum[i];
        }

        return max;

        
    }
}