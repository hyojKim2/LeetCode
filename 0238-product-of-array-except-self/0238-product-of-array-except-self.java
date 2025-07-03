class Solution {
    public int[] productExceptSelf(int[] nums) {
        //O(n)안에
        int multi=1;
        for(int num:nums){
            multi*=num;
        }

        int[] arr = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(multi==0){
                    arr[i]=1;
                    for(int k=0; k<nums.length;k++){
                        if(k!=i){
                            arr[i]*=nums[k];
                        }
                    }
                }
                else{
                    arr[i]=0;
                }
            }
            else{
                arr[i] =(  multi / nums[i]);
            }

        }

        return arr;
        
    }
}