class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if (!output.isEmpty()) return output.pop();

        while (!input.empty()) {
            output.push(input.pop());
        }

        if (output.isEmpty()) return -1;
        return output.pop();
    }
    
    public int peek() {
        int v = pop();
        output.push(v);
        return v;
    }
    
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */