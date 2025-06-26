class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        //초기 prefix 설정
        String prefix=str1;
        String great=str2;
        String small=str1;
        if(Math.min(str1.length(), str2.length())==str2.length()){
            prefix=str2;
            great=str1;
            small=str2;
        }

        while(prefix.length()>0){
            if (great.replace(prefix, "").isEmpty() && small.replace(prefix, "").isEmpty()) 
            {
                return prefix;
            }
            else{
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }

        return "";
        
    }

}