import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        boolean answer = true;
        HashMap<Character, Integer> mag = new HashMap<>();
        HashMap<Character, Integer> ran = new HashMap<>();


        for(int i=0;i<ransomNote.length() ; i++){
            char c = ransomNote.charAt(i);
            ran.put(c, ran.getOrDefault(c, 0)+1);
        }

        for(int i=0;i<magazine.length() ; i++){
            char c = magazine.charAt(i);
            mag.put(c, mag.getOrDefault(c, 0)+1);
        }


        // ransom이 mag 만들 수 있는지 검사
        for(Map.Entry<Character, Integer> entry : ran.entrySet()){
            char c = entry.getKey();        
            if( mag.containsKey(c)==false || mag.get(c) < entry.getValue()) {
                return false;
            }
        }

        return answer;

    }
}