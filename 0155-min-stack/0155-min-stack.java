class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {

        stack=new Stack<>();
        min = new Stack<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(!min.isEmpty() ){
            if(min.peek() > val)
                min.push(val);
            else
                min.push(min.peek());
        }
        else{
            min.push(val);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            min.pop();
        }
        
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
       
        
    }
    
    public int getMin() {

        if(min.isEmpty()){
            return -1;
        }
        return min.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */