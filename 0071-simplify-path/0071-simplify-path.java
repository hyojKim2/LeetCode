class Solution {
    public String simplifyPath(String path) {

        String[] words = path.split("/+"); // '/'가 하나 이상일 때 자르기 //, ///... 
        System.out.println(String.join("+", words));

        Stack<String> stack = new Stack<>();

        for(String word: words){
            
            if(word.equals(".") || word.equals("")){
                continue;
            }
            else if(word.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();    
                }
            }
            else{
                stack.push(word);
            }
        }

        return "/"+ String.join("/", stack);
        
    }
}