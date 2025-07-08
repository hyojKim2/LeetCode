class Solution {
    public void moveZeroes(int[] nums) {
    int left = 0;  // 0을 찾는 포인터
    int right = 0; // 0이 아닌 숫자를 찾는 포인터

    while (right < nums.length) {
        if (nums[right] != 0) {
            // 0이 아닌 값을 왼쪽으로 옮김
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
        }
        right++;
    }
}

}