/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {


        int pick=0;
        int low = 1;
        int high= n;

        while(low<=high){
            pick =  low  + (high- low ) /2 ;
            int guess = guess(pick);
            if(guess == -1 ){ // pick  > num 
                high= pick -1;
            }
            else if (guess== 1 ){
                low = pick+1;
            }
            else if(guess==0){
                return pick;
            }

        }


        return pick;
        
    }
}