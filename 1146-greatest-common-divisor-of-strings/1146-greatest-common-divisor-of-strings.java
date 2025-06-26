class Solution {

    //최대공약수에서 x,y와 y,r의 최대공약수는 같다는 점을 이용
    // x%y = r  - > y%r=0이 되는 y이 최대공약수이다. 
    int getGcdLength(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return getGcdLength(b, a%b);
        }
    }

    public String gcdOfStrings(String str1, String str2) {

        //회문인 경우를 체크 
        if(!((str1+str2).equals(str2+str1))){
            return "";
        }
        int gcdLength = getGcdLength(str1.length(), str2.length());
        return str1.substring(0, gcdLength);

        
        // //초기 prefix 설정
        // String prefix=str1;
        // String great=str2;
        // String small=str1;
        // if(Math.min(str1.length(), str2.length())==str2.length()){
        //     prefix=str2;
        //     great=str1;
        //     small=str2;
        // }

        // while(prefix.length()>0){
        //     if (great.replace(prefix, "").isEmpty() && small.replace(prefix, "").isEmpty()) 
        //     {
        //         return prefix;
        //     }
        //     else{
        //         prefix=prefix.substring(0,prefix.length()-1);
        //     }
        // }

        // return "";
        
    }

}