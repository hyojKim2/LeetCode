import java.util.*;


class Solution {



    public int[] topKFrequent(int[] nums, int k) {

        HashMap <Integer, Integer> frequentMap = new HashMap<Integer, Integer>() ;   // num을 키로하고 개수를 담는 해시맵 초기화 

        for(int num: nums){
            int keyValue= 0 ;
            if(frequentMap.containsKey(num)){ //해시맵의 키에 num이 있으면  
                keyValue=frequentMap.get(num) ; //현재 num에 해당하는 value값 가져옴 
            }

            frequentMap.put(num, keyValue +1);
        }

        
        Map<Integer, List<Integer>> freMultiMap = new HashMap <Integer, List<Integer>> (); //빈도: 키리스트를 담는 멀티해시맵

        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            int freq= frequentMap.get(entry.getKey()); //현재 num에 대한 빈도 
            if(!freMultiMap.containsKey( freq)){
                freMultiMap.put(freq, new ArrayList<Integer>());
            }
            freMultiMap.get(freq).add(entry.getKey()); // 현재 키값을 빈도에 대해 추가 
        };

    
        List<Integer> allValues = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : freMultiMap.entrySet()) { //해시맵에 대해 키값들을 모두 arrayList에 담아줌
            allValues.addAll(entry.getValue());
        }


        int[] answer=new int[k];

        int size = allValues.size();
        for (int i = 0; i < k; i++) { //끝에서부터 k개의 원소만 answer에 담음
            answer[i] = allValues.get(size - k + i);
        }
        return answer;
    }
}