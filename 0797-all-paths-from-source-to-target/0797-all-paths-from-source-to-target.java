import java.util.*;

class Solution {
    static List<List<Integer>> answer ;
    static int [][] mstGraph ;
    static int target;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        mstGraph=graph;
        target=graph.length;
        answer=new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        DFS( graph[0], temp, 0);
        return answer;
    }

    static public void DFS ( int[] graph, List<Integer> temp, int val){
        List<Integer> currentPath = new ArrayList<>(temp); //새로운 리스트 선언하여 현재 temp리스트 복사

        currentPath.add(val);
        if(val== target-1 ){ //타겟 도달시 answer에 add
            answer.add(currentPath);
        }
        else{
            for (int i : graph){ //재귀 DFS
                DFS(mstGraph[i], currentPath, i );
            }

        }

    }
}