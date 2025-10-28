class Solution {
    public int removeDuplicates(int[] nums) {

        int k=0;
        Set<Integer> show  = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!show.contains(nums[i])){
                nums[k]=nums[i];
                show.add(nums[i]);
                k++;
            }



        }

        return k;
        
    }
}