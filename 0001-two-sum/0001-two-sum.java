class Solution {
    public int[] twoSum(int[] nums, int target) {

        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(temp+nums[j]==target){
                    int[] arr =new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    return arr;
                }
            }
        }
        return null;

        
    }
}