class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // 이전 윈도우와, 현재 윈도우의 양끝 변동값 확인해서 불필요한 계산 스킵 가능


        int max =0;
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        int prev = max;

        System.out.println(max);


        for(int i =1 ; i <= nums.length - k; i++ ){
             
            //prev 구하기. 
            if( nums[i-1]   <=  nums[i+ k-1]){
                prev=0;
                for(int j = i ; j<i +k ; j++){
                    prev+=nums[j];
                }
                System.out.println("i: " + i + " " + prev);
            }
            if(prev > max ){
                max=prev;
            }

        }

        return (double) max/k;
        
    }
}