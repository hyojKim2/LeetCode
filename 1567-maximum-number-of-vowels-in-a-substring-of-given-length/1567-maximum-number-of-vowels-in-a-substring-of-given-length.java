class Solution {
    public int maxVowels(String s, int k) {

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


        int now=0;
        int max=0;

        // 최초 모음 계산 
        for(int i  =0 ;i<k;i++){
            if(set.contains(s.charAt(i))){
                max++;
            }
        }

        now =max;

        
        int i = 1;


        while( i<= s.length() - k ){

            if(set.contains(s.charAt(i-1))){
                now--;
            }   

            if(set.contains(s.charAt(i+k-1))){
                now++;
            }

            if(now>max){
                max=now;
            }

            i++;

        }

        return max;

        
    }
}