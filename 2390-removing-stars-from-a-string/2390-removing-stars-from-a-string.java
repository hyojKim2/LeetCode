/*

1. 스택 생성
2. s의 문자열을 하나씩 담는다. 
3. *를 만나면 삽입하지 않고 pop
4. s를 모두 검사하고, 스택에 담긴 문자열 sort하여 반환 

*/

import java.util.*;

class Solution {

    Stack<Character> stack; //스택 선언 
    public String removeStars(String s) {
        
        stack=new Stack<>(); //스택 초기화
        addString(s);

        System.out.println(stack);

        String answer="";
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }

        StringBuffer str=  new StringBuffer(answer);  //StringBuffer 클래스는 멀티쓰레드에 안전함

        return str.reverse().toString();

    }

    private void addString(String s){
        for(char  c:s.toCharArray()){ //문자열을 문자 배열로 변환
            if(c!='*')
                stack.push(c);
            else
                stack.pop();    
        }
    }
}

