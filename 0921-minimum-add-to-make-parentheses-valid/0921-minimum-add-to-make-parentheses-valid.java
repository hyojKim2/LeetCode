/*
1. 스택을 만든다. 
2. 스택에 s의 원소 하나씩 삽입
3. )이 주어졌을 때 stack.peek()가 (이면 pop
4. 스택 크기를 return  
*/
import java.util.*;

class Solution {
    
    public int minAddToMakeValid(String s) {

        Stack <Character> stack =new Stack<>(); //스택 선언
        for(char c : s.toCharArray()){
            if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
            }
            else
                stack.push(c);

        }    

        return stack.size();
        
    }
}