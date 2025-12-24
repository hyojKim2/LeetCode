import java.util.*;


class Solution {
    public int orangesRotting(int[][] grid) {

        int time = -1; //time
        int[][] way = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // 2는 썩은 오렌지, 
        int m=grid.length; // 세로, 행 
        int n= grid[0].length; //가로, 열  

        Queue< int[]> q = new LinkedList<>(); //썩은 오렌지 
        boolean[][] visit = new boolean[m][n]; //방문 처리 

        int fresh = 0 ;//신선 오렌지 

        //모든 썩은 오렌지를 찾아 큐에 넣는다.
        for(int i =0;i <m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) {
                    q.offer(new int[]{i, j});
                    visit[i][j]=true;
                }
                else if (grid[i][j]==1) fresh++;
            }
        }

        // 상자에 신선한 오렌지가 없는 경우. 
        if( fresh==0) return 0; 
        
        //큐가 빌 때까지 시작. 
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] now = q.poll();
                int nr = now[0];
                int nc = now[1];

                for(int[] go:way){
                    int r = nr+ go[0]; // 행
                    int c = nc+ go[1]; // 열

                    // 범위 검사
                    if( r >= m || r <0 ||  c >=n || c <0)continue;
                    // 방문 & 빈 자리 확인 
                    if(visit[r][c]==true || grid[r][c]==0) continue;

                    // 정상 오렌지라면 
                    visit[r][c] = true; //방문 처리
                    grid[r][c]= 2; // 썩음 처리 
                    q.offer(new int[]{r, c});

                }

            }

            time++; //큐가 지나면 시간(분) 증가 

        }

        // 정상 오렌지가 있는지 체크 
        for(int i =0;i <m;i++){
            for(int j=0;j<n;j++){
                //System.out.print(grid[i][j] + " ");
                if(grid[i][j]==1) return -1;
            }
            //System.out.println();
        }


        return time;
        
    }
}