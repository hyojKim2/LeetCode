class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        //스택으로 푼다. visited필요. 
        // 복잡도 n^2 가능 
        Stack<Integer> stack = new Stack<Integer>();
        int[] visited = new int[rooms.size()];

        //0번째 방 키를 음
        List<Integer> keys = rooms.get(0);
        for(Integer key: keys) stack.push(key);
        visited[0]=1;

        while(!stack.isEmpty()){
            
            int target = stack.pop(); 
            // 이미 방문한 방이면 컨티뉴 
            if(visited[target]==1) continue;

            visited[target]=1; //방문처리
            
            //방에서 찾은 열쇠를 스택에 넣어줌. 
            keys = rooms.get(target);
            for(Integer key: keys) stack.push(key);


        }

        for(int vis: visited){
            if(vis==0) return false;
        }
        return true;
        
    }
}