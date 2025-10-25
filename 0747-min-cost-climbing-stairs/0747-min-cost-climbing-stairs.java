class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int size= cost.length;
        int[] sum = new int[size];
        // n위치에서, n-1과 n-2의 합 중 작은 것 + cost[n]을 저장

        //초기 세팅
        sum[0]=cost[0]; 
        sum[1]=cost[1];

        for(int i=2;i<size;i++){
            
            sum[i]= cost[i]+ Math.min(sum[i-1], sum[i-2]);

        }

        return Math.min(sum[size-1], sum[size-2]);
        
    }
}