import java.util.*;


class Solution {

    //탐색방향 상하좌우
    int[][] go = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {

        //입구는 출구가 아니며, 가장 가까운 출구와 거리를 출력
        int answer = -1;

        //방문여부, 
        // ===> 이동횟수를 level로 for문 설정해서, 현재 위치에서 상하좌우 이동시 출구인지 찾는다. 즉시 탐색ㅈ ㅗㅇ료가 가능하다. 


        int rows =maze.length;
        int cols = maze[0].length;

        int depth =1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        q.offer(entrance);
        visited[entrance[0]][entrance[1]]= true;

        while(!q.isEmpty()){
            int size =q.size();


            //레벨 설정. 현재 큐는 모두 동레벨 
            for(int i=0;i< size ;i++){
                int[] now = q.poll();
                int r = now[0];
                int c = now[1];
                
                for(int j=0;j<4;j++){
                    int[] way = go[j];
                    int nr= now[0]+way[0]; // 행
                    int nc = now[1] + way[1]; //열 

                    // 다음 노드가 범위 밖이라면 패수ㅡ 
                    if ( nr <0 || nr>= rows ||  nc < 0 || nc >= cols )
                        continue;
                    //벽(+)이거나 방문했다면 pas
                    if(maze[nr][nc] == '+' || visited[nr][nc]) continue;


                    visited[nr][nc] = true;
                    // 출구라면 
                    if( ( nr==0 || nr==rows-1 || nc ==0 || nc== cols-1))
                        return depth;
                
                    // 길이라면 
                    else q.offer( new int []{nr, nc});

                    //
                    
                }

            }

            depth++;

        }


        return answer;
        
    }
}