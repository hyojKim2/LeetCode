import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        StringBuilder current = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>(); 
        /**
        1. /~~ 형태로 하나의 스택에 들어감
        2. 만약 /..로 끝난 상태(path마지막) -> 스택 지워줌
        3. 만약 /인데 current에 / 이 있음 -> 컨티뉴. 
        4.  
         */
         


         for(int i=0;i<path.length();i++){
            char c = path.charAt(i);

            if(c=='/'){
                System.out.println(current.toString());
                if(current.toString().equals("/..")){
                    if(!stack.isEmpty())
                        {
                            
                    System.out.println("ss" + stack.peek());
                            stack.pop();
                        }
                    current=new StringBuilder();
                }
                else if(current.toString().equals("/.")){
                    current=new StringBuilder();
                }
                else if(current.toString().equals("/")){
                    continue;
                }
                if(!current.isEmpty())
                    stack.push(current);
                current= new StringBuilder();
            }

            current.append(c);
            //마지막 디렉토리 처리 
            if(i==path.length()-1){
                System.out.println(String.join("",stack) + "  last:"  + current.toString());
                if (current.length() > 0 && current.charAt(current.length() - 1) == '/') {
                    stack.push(new StringBuilder(current.substring(0, current.length() - 1)));

                }

                else if(current.length()> 0 && current.toString().equals("/..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                }
                else if(current.length()> 0 && current.toString().equals("/.")){
                    break;
                }
                else{
                    stack.push(current);

                }
            }
         }
        

         if(!stack.isEmpty() && stack.size()>1 && stack.peek().toString().equals("/")){
            stack.pop();
         }
         if(String.join("",stack).equals("")){
            return "/";
         }
         return String.join("",stack);

        
    }
}