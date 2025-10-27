class Solution {
    public int maxProfit(int[] prices) {



        int min = 10001;
        int profit=0;
        for(int price:prices ){

            if(price-min>profit) 
                profit=price-min;
            if (min > price) min=price;
        }
        return profit;
        
    }
}