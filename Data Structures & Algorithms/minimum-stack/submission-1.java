class MinStack {
    Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
        {
            st.push(new int[]{val,val});
        }
        else
        {
            int[] top = st.peek();
            int minimum = top[1];
            st.push(new int[]{val,Math.min(val,minimum)});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        int[] top = st.peek();
        return top[0];
    }
    
    public int getMin() {
        int[] top = st.peek();
        return top[1];
    }
}
