import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int answer=0;
        // 노드 이웃 정보 
        List<List<Integer>> list = new ArrayList<>();
        // 일반적 visit보다, 해당 노드가 0에 도달했는지 정보 
        int[] visit=  new int[n];
        // 간선 방향 정보
        Set<String> direction = new HashSet<>();
        


        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }

        //양방향 연결 
        for(int[] c:connections){
            list.get(c[0]).add(c[1]);
            list.get(c[1]).add(c[0]);

            //방향
            direction.add(c[0] +  "->" + c[1]);
        }

        // DFS 탐색
        Stack<Integer> st = new Stack<>();
        st.push(0);
        visit[0]=1;
        while(!st.isEmpty()){

            int now = st.pop();
            
            // 이웃 노드 넣기 
            for(int neigh : list.get(now)){

                // neigh 노드는 0에 도달했는가? 
                if(visit[neigh]==1) continue;
                
                //방향이 이웃-> 나 (0쪽으로 향하는지) 확인 
                if(!direction.contains(neigh + "->" + now) ){
                    answer++;
                    direction.add(neigh + "->" + now);
                }//

                visit[neigh]=1;  
                st.push(neigh);
            }

        }
        

        return answer;


    }
}