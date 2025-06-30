class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int answer= 0;
        int ex=0;

        for(int flower:flowerbed){
            if(ex!=1 && flower!=1){
                answer++;
                ex=1;
            }
            else if(ex==1 && flower==1){
                answer--;
                ex=flower;
            }
            else{
                ex=flower;
            }
        }
        return n<=answer;
        
    }
}