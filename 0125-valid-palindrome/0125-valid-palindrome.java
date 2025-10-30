class Solution {
    public boolean isPalindrome(String s) {

        String str =s.toUpperCase(); //대문자 변환
        str=str.replaceAll("[^0-9A-Z]","");//문자 외 제거 

        int start=0;
        int end=str.length()-1;

        while(start<=end){
            if(str.charAt(start++) !=str.charAt(end--)) return false;

        }
        
        return true;
    }
}