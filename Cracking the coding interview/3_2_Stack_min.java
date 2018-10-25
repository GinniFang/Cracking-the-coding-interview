/* Stack min
problem description
How would you design a stack which, in addition
to push and pop, has a funtion min which returns
the minimum element?
Same as the leetcode problem #155 */

class MinStack {
    Stack<Integer> stack  = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        //pay attention 
        //!!you cannot use min_stack==null which will throw
        //EmptyStackException
        if(min_stack.isEmpty()||min_stack.peek()>x){
            min_stack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        //pay attention here, we should use equals, Integer is an object
        if(!min_stack.isEmpty()&&stack.peek().equals(min_stack.peek())){
            min_stack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}