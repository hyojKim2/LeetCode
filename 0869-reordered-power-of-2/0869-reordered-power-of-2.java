import java.util.*;

class Solution {
    
    static int n_length;
    static String numberStr;
    static boolean visit[];

    public boolean reorderedPowerOf2(int n) {
        numberStr = Integer.toString(n); // n을 문자열로 변환
        n_length = numberStr.length(); // n을 변환한 문자열의 길이
        visit = new boolean[n_length]; // 문자 방문 여부, false 초기화

        return reorder("");
    }

    static public boolean reorder(String temp) {
        for (int i = 0; i < n_length; i++) {
            if (temp.length() == 0 && numberStr.charAt(i) == '0') { // 맨 앞에 0이 오지 않게
                continue;
            }

            if (!visit[i]) { // 현재 인덱스 문자를 방문하지 않았으면 추가
                visit[i] = true; // 현재 문자 방문 처리
                String newTemp = temp + numberStr.charAt(i); // 새로운 문자열 생성

                if (newTemp.length() == n_length) { // 모든 문자를 다 사용한 경우
                    if (isPowerOfTwo(Integer.parseInt(newTemp))) { // 2의 제곱인지 검사
                        return true; // 2의 제곱이면 조기 종료
                    }
                } else {
                    if (reorder(newTemp)) { // 재귀 호출
                        return true; // 2의 제곱을 찾으면 조기 종료
                    }
                }

                visit[i] = false; // 백트래킹
            }
        }

        return false;
    }

    static public boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

}
