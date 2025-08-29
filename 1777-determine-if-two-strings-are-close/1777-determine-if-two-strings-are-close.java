class Solution {
    public boolean closeStrings(String word1, String word2) {

        //길이가 동일하지 않다면 
        if(word1.length()!=word2.length()){
            return false;
        }

        //1에 의해, 순서는 상관없어짐. 알파벳 절대개수가 중요
        //2에 의해, 알파벳 등장횟수도 유연하게 가능함. 
        //word1의 맵을 만들어 알파벳: 개수 저장.  word2에서도 맵을 만들고, 두 맵의 키의 밸류들의 값을 비교!


        HashMap<Character, Integer> map1 = getMap(word1);
        HashMap<Character, Integer> map2 = getMap(word2);

        System.out.println(map1);
        System.out.println(map2);

        //키 집합 동일한지 비교
        if(!map1.keySet().equals(map2.keySet())){
            return false;
        }


        //밸류집합 동일 비교 
        List<Integer> val1= new ArrayList<>(map1.values());
        List<Integer> val2= new ArrayList<>(map2.values());
        
        
        Collections.sort(val1);
        Collections.sort(val2);
        
        if(!val1.equals(val2)){
            return false;
        }

        return true;
        
    }

    public HashMap<Character, Integer> getMap(String words){
        
        HashMap<Character, Integer> map  = new HashMap<>();
        for(Character word:words.toCharArray()){
            map.put(word, map.getOrDefault(word, 0) +1);
        }
        return map;

    }
}