class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0;i < n;i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,(a,b) -> b[0] - a[0]);
        double[] time = new double[n];
        for(int i = 0;i < n;i++)
        {
            time[i] = (double)(target - cars[i][0]) / cars[i][1];
        }
        double[] pge = previousGreaterElement(time);
        int count = 0;
        for(int i = 0;i <pge.length;i++)
        {
            if(pge[i] == -1)
            {
                count++;
            }
        }
        return count;
    }
    public double[] previousGreaterElement(double[] time)
    {
        Stack<Double> st = new Stack<>();
        double[] pge = new double[time.length];
        pge[0] = -1;
        st.push(time[0]);
        for(int i = 1;i < time.length;i++)
        {
            while(!st.isEmpty() && time[i] > st.peek())
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pge[i] = -1;
            }
            else
            {
                pge[i] = st.peek();
            }
            st.push(time[i]);
        }
        return pge;
    }

}
