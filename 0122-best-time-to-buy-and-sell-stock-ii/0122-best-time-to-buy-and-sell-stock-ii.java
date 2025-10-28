class Solution {
    public int maxProfit(int[] prices) {


        // i, i-1을 기준으로 크면 팔고 작으면 사기 ? 

        int got = prices[0];
        int profit=0;
        for(int i=0;i<prices.length ;i++){
            if (i==prices.length-1 && prices[i]> got  ) {
                    profit+= prices[i] - got;
                    break;
            }
            else if ( prices[i]  > got && prices[i] > prices[i+1] ){ //팔어
                profit+= prices[i] - got;
                got=prices[i];
            }
            else if( got > prices[i]){
                got=prices[i];
            }
        }

        return profit;
        
        
    }
}