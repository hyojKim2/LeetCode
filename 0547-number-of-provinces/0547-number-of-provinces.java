class Solution {
    boolean[] visit ;
    int provinces;
    int[][] conMap;
    public int findCircleNum(int[][] isConnected) {
        
        visit = new boolean[200];
        provinces=0;
        conMap=isConnected;

        //지방의 개수 n^3 까지 ok. 

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<isConnected.length;i++){
            if(visit[i]==true) continue;
            visit[i]=true;
            for(int j=0;j<isConnected.length;j++){
                if(j!=i && isConnected[i][j]==1) DFS(j);
            }
            provinces++;
        }

        return provinces;
        
    }

    public void DFS(int city){

        visit[city] = true;// 방문설정
        for(int i=0;i<conMap.length;i++){ //연결된 도시 방문 
                if(i!=city && visit[i]!=true && conMap[city][i]==1 ) DFS(i);
        }
    }
}