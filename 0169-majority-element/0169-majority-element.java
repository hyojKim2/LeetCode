class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault( num, 0 ) +1);
        }
        int max=0;
        int appe=0;
        for( Map.Entry<Integer, Integer> entry: map.entrySet()){
            if( entry.getValue() > appe ){
                appe= entry.getValue();
                max=entry.getKey();
            }

        }
        return max;
        
        
    }
}