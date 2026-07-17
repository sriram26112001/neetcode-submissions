class Solution {
    public int trap(int[] height) {
        int[] maxRight = nextMaximumElement(height);
        int[] maxLeft = previousMaximumElement(height);
        int sum = 0;
        for(int i = 0;i < height.length ; i++ )
        {
            int waterStored = Math.min(maxRight[i],maxLeft[i]) == -1 ? 0 : Math.min(maxRight[i],maxLeft[i]) - height[i];
            sum = sum + waterStored;
        }
        return sum;
    }
    public static int[] nextMaximumElement(int[] height)
    {
        int[] maxRight = new int[height.length];
        int maxSoFar = -1;
        for(int i = height.length - 1;i >= 0; i--)
        {
            if(height[i] > maxSoFar)
            {
                maxRight[i] = -1;
            }
            else
            {
                maxRight[i] = maxSoFar;
            }
            maxSoFar = Math.max(maxSoFar,height[i]);
        }
        return maxRight;
    }

    public static int[] previousMaximumElement(int[] height)
    {
        int[] maxLeft = new int[height.length];
        int maxSoFar = -1;
        for(int i = 0;i < height.length; i++)
        {
            if(height[i] > maxSoFar)
            {
                maxLeft[i] = -1;
            }
            else
            {
                maxLeft[i] = maxSoFar;
            }
            maxSoFar = Math.max(maxSoFar,height[i]);
        }
        return maxLeft;
    }
}
