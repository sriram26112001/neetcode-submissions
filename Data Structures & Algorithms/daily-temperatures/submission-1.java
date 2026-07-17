class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //next greater element
        int[] nge = nextGreaterIndexes(temperatures);
        int[] result = new int[nge.length];
        for(int i = 0; i <nge.length;i++)
        {
            if(nge[i] == -1)
            {
                result[i] = 0;
            }
            else
            {
                result[i] = nge[i] - i;
            }
        }
        return result;
    }
    public static int[] nextGreaterIndexes(int[] temperatures)
    {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[temperatures.length];
        nge[temperatures.length - 1] = -1;
        st.push(temperatures.length - 1);
        for(int i = temperatures.length - 2;i >= 0;i--)
        {
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nge[i] = -1;
            }
            else
            {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
}
