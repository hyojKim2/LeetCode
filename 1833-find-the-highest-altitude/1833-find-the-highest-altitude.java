class Solution {
    public int largestAltitude(int[] gain) {

        //point [i+1]  = gain [0: i] 까지의 합이다.  
        int max =0 ;
        int sum=0;
        for(int i = 0 ; i<gain.length; i++){
            sum +=gain[i];
            if(sum>max){
                max=sum;
            }

        }
        return max;
        
    }
}