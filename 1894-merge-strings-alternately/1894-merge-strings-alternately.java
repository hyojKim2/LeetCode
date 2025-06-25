class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        
        // 짧은 것 
        int minLength = Math.min(word1.length(), word2.length());
        // 문자열 두 개 중 더 긴 것의 길이 
        int maxLength= Math.max(word1.length(), word2.length());
        
        String longString = "";

        if(word1.length() > word2.length()){
            longString=word1;
        }
        else{
            longString=word2;
        }
        

        String answer="";

        for(int i=0;i<minLength;i++){
            answer+= "" + word1.charAt(i) + word2.charAt(i);
        }



        return answer + longString.substring(minLength );

    }
}