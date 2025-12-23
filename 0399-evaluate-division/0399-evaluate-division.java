import java.util.*;

class Solution {
    Map<String, List<List<String>>> map ;
    Set<String> set ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] answer = new double[queries.size()];
        map = new HashMap<>();
        set = new HashSet<>();

        // 정방향, 역방향 연산값을 map에 저장한다. 
        for(int i=0;i<values.length;i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            set.add(a);
            set.add(b);
            
            // key를 처음 삽입시 리스트 생성 
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add( new ArrayList<>(List.of( b, values[i] + "")));

            map.putIfAbsent(b, new ArrayList<>());
            map.get(b).add(new ArrayList<>(List.of( a, (1 /values[i]) + "")));
        }

        int cnt=0;
        for(List<String> query : queries){
            
            String a= query.get(0);
            String b =query.get(1);
            Set<String> visited = new HashSet<>();
            answer[cnt++] = getCal(a, b, 1, visited);

        }

        return answer;
        
    }

    public double getCal(String start, String target, double prod, Set<String> visited) {
        
        // 문자 포함하지 않을 때 
        if (!set.contains(start) || !set.contains(target)) return -1;
        //타깃 도달시 
        if (start.equals(target)) return prod;

        //방문처리 
        visited.add(start);

        if(map.containsKey(start)){
            for(List<String> query : map.get(start)){
                
                String neigh = query.get(0);
                double val  = Double.parseDouble(query.get(1));
                if(!visited.contains(neigh)){
                    double res = getCal(neigh, target, prod*val,visited );

                    if(res!= -1 ) return res;
                }

            }
        }

        // 그렇지 않다면 리턴 
        return -1;
    }


}