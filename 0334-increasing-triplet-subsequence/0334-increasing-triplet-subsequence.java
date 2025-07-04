class Solution {
    public boolean increasingTriplet(int[] nums) {

        int ex=nums[0];

        int cnt=1;

        // 중복 제거용 Set
        Set<Integer> uniqueSet = new HashSet<>();

        // 배열 요소를 Set에 추가
        for (int num : nums) {
            uniqueSet.add(num);
        }
        if(uniqueSet.size()==2){
            return false;
        }

        for(int i=1; i< nums.length-1; i++){
            cnt=1;
            ex=nums[i-1];
            for(int j=i; j<nums.length ; j++){
                if(ex>nums[j] && nums[j]>nums[i-1]){
                    ex=nums[j];
                }
                
                if(ex < nums[j]){
                    cnt++;
                    ex=nums[j];
                }
                
                if(cnt==3){
                    return true;
                }
            }
        }

        return false;
        
    }
}