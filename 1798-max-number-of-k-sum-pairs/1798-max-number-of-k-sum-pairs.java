class Solution {
    public int maxOperations(int[] nums, int k) {

        // 크기 순으로 정렬
        // 양 끝의 합 < k -> left ++
        // 양 끝의 합 > k -> right ++
        // while (left<right)

        int answer =0;
        int left =0; 
        int right = nums.length -1  ;

        // 배열 오름차순 정렬
        Arrays.sort(nums);

        while(left < right){
            
            int now = nums[left] +  nums[right];
            if(now < k){
                left++;
            }
            else if( now > k ){
                right --;
            }
            else {
                answer++;
                left++;
                right--;
            }
        }

        return answer;
        
    }
}