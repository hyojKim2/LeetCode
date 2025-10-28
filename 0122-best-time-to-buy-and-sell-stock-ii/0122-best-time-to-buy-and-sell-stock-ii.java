class Solution {
    public int maxProfit(int[] prices) {


        // i, i-1을 기준으로 크면 팔고 작으면 사기 ? 

        int got = prices[0];
        int profit=0;
        for(int i=0;i<prices.length ;i++){
            if( prices[i]> got){
                profit+=prices[i]-got;
            }
            got=prices[i];
        }


        return profit;
        
        
    }
}