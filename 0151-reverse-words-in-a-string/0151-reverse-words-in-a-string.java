class Solution {
    public String reverseWords(String s) {

        List<String> wordList = new ArrayList<>();
        String ss = "";
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                ss+=s.charAt(i);
            }
            else{
                if(!ss.equals("")){
                    wordList.add(ss);
                    ss="";
                }
            }
        }
        //마지막 저장
        if(!ss.equals("")){
            wordList.add(ss);
        }


        String answer ="";
        for(int i=wordList.size()-1; i>=0;i--){
            answer+=wordList.get(i)+" ";
        }

        return answer.substring(0, answer.length()-1);
        
    }
}