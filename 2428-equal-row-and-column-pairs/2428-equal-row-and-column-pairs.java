class Solution {
    public int equalPairs(int[][] grid) {

        /*
        해시맵에 로우 List 저장(순서보장) -> 그 다음 컬럼 확인하며 일치하는지 체크.  
        3 1 2 2
        1 4 4 4
        2 4 2 2
        2 5 2 2
        */

        HashMap<Integer, List<Integer>> map  = new HashMap<>();
        int answer=0;

        for(int i = 0; i <grid.length;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0 ; j<grid.length;j++){
                list.add(grid[j][i]);
            }
            map.put(i, list);
        }

        


        List<List<Integer>> mapList  = new ArrayList<>(map.values());

        for(int i = 0; i <grid.length;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0 ; j<grid.length;j++){
                list.add(grid[i][j]);
            }
            
            if(mapList.contains(list)){
                // 중복 처리 
                answer+= Collections.frequency(mapList,list);
            }
        }

        return answer;

        
    }
}