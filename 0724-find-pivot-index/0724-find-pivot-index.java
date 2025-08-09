class Solution {
    public int pivotIndex(int[] nums) {

        //

        int[] leftSum=new int [nums.length];
        int[] rightSum=new int [nums.length];

        leftSum[0]=nums[0];
        rightSum[nums.length-1]=nums[nums.length-1];
        
        for(int i=1;i<nums.length;i++){
            leftSum[i]+=leftSum[i-1]+nums[i];
        }
        for(int k=nums.length-2;k>=0;k--){
            rightSum[k]+= rightSum[k+1]+nums[k];
        }

        for(int j=0;j<nums.length;j++){
            if(leftSum[j]==rightSum[j]){
                return j;
            }
        }
        return -1;

        
    }
}