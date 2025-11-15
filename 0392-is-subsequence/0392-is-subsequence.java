class Solution {
    public boolean isSubsequence(String s, String t){

        if(t.length()  < s.length()) return false;

        int i=0;
        int k=0;
        while( i< s.length()  && k <t.length())
        {
            if(s.charAt(i)==t.charAt(k)){
                i++;
            }
            k++;
        }

        return i == s.length();





        
    }
}

        // int i=0;
        // int k=0;

        // while( k  < t.length() &&  i <s.length()){
        //     if(s.charAt(i) == t.charAt(k)){
        //         i++;
        //     }
        //     k++;
        // }

        // return i == s.length();