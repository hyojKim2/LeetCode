class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c==')'){
                if(st.size()==0){
                    return false;
                }
                if(st.peek()=='('){
                    st.pop();
                    continue;
                }
                else if(st.peek()=='[' || st.peek()=='{'){
                    return false;
                }
            }
            else if(c==']'){
                if(st.size()==0){
                    return false;
                }
                if(st.peek()=='['){
                    st.pop();
                    continue;
                }
                else if(st.peek()=='(' || st.peek()=='{'){
                    return false;
                }

            }
            else if(c=='}'){
                if(st.size()==0){
                    return false;
                }
                if(st.peek()=='{'){
                    st.pop();
                    continue;
                }
                else if(st.peek()=='[' || st.peek()=='('){
                    return false;
                }

            }
            st.push(c);
        }

        if(st.size()>0){
            return false;
        }
        return true;
        
    }
}