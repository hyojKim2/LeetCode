import java.util.*;

class Solution {

    public String predictPartyVictory(String senate) {

int n = senate.length();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        // 각 당 의원 인덱스를 큐에 넣기
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        // 라운드 시작
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();

            if (rIndex < dIndex) {
                // Radiant가 먼저 행동 → Dire 의원 제거
                rQueue.add(rIndex + n);
            } else {
                // Dire가 먼저 행동 → Radiant 의원 제거
                dQueue.add(dIndex + n);
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}