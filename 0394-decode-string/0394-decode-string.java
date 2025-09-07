import java.util.*;

class Solution {
    public String decodeString(String s) {
        /**

        케이스별로 경우를 나누기. 
        ]이 나오면 [ 까지 닫아줘야함. 숫자도 가져야함. 
        1. 숫자 스택
        2. [] 안의 문자를 각자 저장할 스택 필요. 
        3. 문자스택에 담을 수 있는 현재 문자열 저장 필요
        4. 완료된 문자열을 저장하는 (정답) 문자열 필요
         */

        Stack <Integer> numStack = new Stack<>();
        Stack <StringBuilder> sbStack = new Stack<>(); 
        StringBuilder current = new StringBuilder(); // 유지해갈 정답 문자열. 
        int k =0;

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(Character.isDigit(c)){
                k= 10 *k + (c-'0');
            }
            else if(c == '['){
                numStack.push(k);
                k=0;
                sbStack.push(current);
                current = new StringBuilder();

            }
            else if(c==']'){
                int repeat = numStack.pop();
                StringBuilder temp = sbStack.pop();
                for(int j=0;j<repeat;j++){
                    temp.append(current);
                }
                current =temp;
            }
            else{
                current.append(c);
            }

        }

        return current.toString();

    }

}
