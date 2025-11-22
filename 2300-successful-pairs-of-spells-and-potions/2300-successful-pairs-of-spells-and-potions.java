import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        Arrays.sort(potions); // 포션 정렬

        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            int left =0;
            int right= m-1;
            int idx=m;
            while(left<=right){
                int mid = (left+right) /2;
                if( (long) spell  * potions[mid] >=success){
                    idx=mid;
                    right=mid-1;
                }
                else {
                    left =mid+1;
                }
            }

            // 성공하는 포션 개수 = 전체 - idx
            result[i] = m - idx;
        }

        return result;
    }

}
