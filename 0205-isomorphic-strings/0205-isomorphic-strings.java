import java.util.*;


class Solution {
    public boolean isIsomorphic(String s, String t) {
        /** 동형을 확인 -> 0100..
         */

        HashMap<Character, Integer> map  = new HashMap<>();
        HashMap<Character, Integer> map2  = new HashMap<>();

        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();

        int n = s.length();

        int c1 = -1;
        int c2 = -1;
        for(int i=0;i<n;i++){
            
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if(!map.containsKey(ss)){
                c1++;
            }if(!map2.containsKey(tt)){
                c2++;
            }

            map.put(ss, map.getOrDefault(ss, c1) );
            map2.put(tt, map2.getOrDefault(tt, c2) );

            l1.add(map.get(ss));
            l2.add(map2.get(tt));


        }

        return l1.equals(l2);
        
    }
}