import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        Arrays.sort(potions); // 포션 정렬

        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            // 최소로 필요한 포션의 strength
            // spell * potion >= success → potion >= success / spell
            long needed = (success + spell - 1) / spell; // 올림 나눗셈

            // 이분 탐색으로 potions에서 needed 이상인 첫 위치 찾기
            int idx = lowerBound(potions, needed);

            // 성공하는 포션 개수 = 전체 - idx
            result[i] = m - idx;
        }

        return result;
    }

    // lowerBound: 배열에서 target 이상이 처음 등장하는 index
    private int lowerBound(int[] arr, long target) {
        int left = 0, right = arr.length - 1;
        int pos = arr.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return pos;
    }
}
