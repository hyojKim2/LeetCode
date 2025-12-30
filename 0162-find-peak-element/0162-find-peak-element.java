import java.util.*;



class Solution {
    public int findPeakElement(int[] nums) {

    // 좌우보다 큰 것을 선택, 배열을 원형 리스트로 간주. 
    
    if(nums.length==1) return 0;
    if (nums.length==2) return Math.max(nums[0], nums[1])==nums[0]? 0 : 1;


    // 기울기를 체크해서, peak쪽으로 이동한다. 
    int answer =0;
    int left=0;
    int right = nums.length-1;
    while(left< right){

        int mid = (left + right)/2;

        if( nums[mid]   < nums[mid+1]){
            left  = mid+1 ;// 
        }
        else right = mid;

    }

    return left ;
        
    }
}