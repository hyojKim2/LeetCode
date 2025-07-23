class Solution {
    public boolean isSubsequence(String s, String t) {

        int i=0;
        int k=0;

        while( k  < t.length() &&  i <s.length()){
            if(s.charAt(i) == t.charAt(k)){
                i++;
            }
            k++;
        }

        return i == s.length();

        
    }
}