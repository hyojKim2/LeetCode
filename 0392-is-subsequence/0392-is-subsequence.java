class Solution {
    public boolean isSubsequence(String s, String t) {

        int i=0;
        int k=0;

        // if(s.length()==0 ){
        //     return true;
        // }

        // if(t.length()==0){
        //     return false;
        // }

        // if(s.length()==1 && t.length()==1){
        //     return s.equals(t);
        // }

        String answer ="";

        while( k  < t.length() &&  i <s.length()){
            
            //같아질때까지
            while( s.charAt(i) != t.charAt(k)){
                k++;
                if( k == t.length()){
                    break;
                }
            }
            //끝까지 다 돌은 상태
            if( k ==t.length() && i ==s.length()-1){
                break;
            }
            //같으면 
            k++;
            answer += s.charAt(i++);
            if( k == t.length()){
                break;
            }
        }

        if(answer.equals(s)){
            return true;
        }


        return false;
        
    }
}