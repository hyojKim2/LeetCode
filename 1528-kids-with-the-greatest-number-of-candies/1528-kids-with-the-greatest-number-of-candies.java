class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> answer = new ArrayList<>();
        int big=0;
        for(int candy:candies){
            if(big<candy){
                big=candy;
            }
        }

        for(int candy: candies){
            int kidGotcandy = candy+extraCandies;
            if(big <= kidGotcandy){
                answer.add(true);
            }
            else{
                answer.add(false);
            }
        }

        return answer;

        
    }
}