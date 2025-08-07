class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // 슬라이딩 윈도우: 이전 윈도우와, 현재 윈도우의 양끝 변동값 확인해서 불필요한 계산 스킵 가능
        int max =0;
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        int sum = max;


        for(int i =1 ; i <= nums.length - k; i++ ){
             
            // 이동하며 값 갱신. 
            sum = sum-nums[i-1] +nums[i+ k-1];
            if(sum > max ){
                max=sum;
            }

        }

        return (double) max/k;
        
    }
}