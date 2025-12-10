import java.util.*;

class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map  =new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int answer=0;

        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));

            // 다음 문자가 더 크면 빼기
            if (i + 1 < s.length()) {
                int next = map.get(s.charAt(i + 1));
                if (curr < next) {
                    answer -= curr;
                    continue;
                }
            }

            // 그렇지 않으면 더하기
            answer += curr;
        }

        return answer;


        
    }
}