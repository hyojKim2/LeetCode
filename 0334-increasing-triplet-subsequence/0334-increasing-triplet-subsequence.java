class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        
        // 두 개의 요소로 계산
        for(int e : nums){
            if(e <= small) small = e;
            else if(e <= second) second = e;
            else return true; 
        }                
        return false;
    }
}

