import java.util.*;

/*
1. arr의 각 요소들의 개수를 구하여 맵에 저장
2. 최대힙에 value를 저장

*/
class Solution {
    
    static PriorityQueue<Integer> pq ;
    static HashMap <Integer,Integer> map ;
    public int minSetSize(int[] arr) {
        
        int half=arr.length/2;
        
        map=new HashMap<>();
        
        for(int a:arr){ //맵에 arr의 원소:개수 저장
            if(!map.containsKey(a))
                map.put(a,1);
            else{
                map.put(a, map.get(a) +1 ); 
            }
        }
        
        
        
        pq=new PriorityQueue <>(Collections.reverseOrder()); //최대힙
        
        for(int key: map.keySet()){
            pq.add(map.get(key));
        }
        
        int cnt= arr.length;
        int answer=0;
        while(cnt>half){
            cnt-=pq.poll();
            answer++;
        }
        return answer;
        
        
    }
}