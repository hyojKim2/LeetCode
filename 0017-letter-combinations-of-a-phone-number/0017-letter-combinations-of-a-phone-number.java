import java.util.*;

class Solution {
    List<String> answer;
    Map<Integer, List<Character> >  map ;
    public List<String> letterCombinations(String digits) {
        answer =  new ArrayList<>();
        map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));


        int[] arr = digits.chars().map(c-> c-'0').toArray();
        
        dfs(0, arr, new StringBuilder());


        return answer;
        
    }

    public void dfs(int index, int[]arr, StringBuilder sb){

        // 
        if(index==arr.length){
            answer.add(sb.toString());
            return;
        }

        int digit=arr[index];
        List<Character> list = map.get(digit);
        for(char ch:list){
            sb.append(ch);
            dfs(index +1, arr, sb);
            sb.deleteCharAt(sb.length()-1); // backtrack;''
        }
    }

}