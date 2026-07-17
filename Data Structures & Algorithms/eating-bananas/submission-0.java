class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maximum (piles);
        //Binary Search
        while(low <= high)
        {
            int mid = (low + high)/2;
            int hours_taken = 0;
            
            for(int i = 0;i < piles.length; i++)
            {
                hours_taken += Math.ceil(piles[i]/(mid * 1.0));
            }

            if(hours_taken <= h)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
    public int maximum(int[] piles)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < piles.length; i++)
        {
            if(piles[i] > max)
            {
                max = piles[i];
            }
        }
        return max;
    }
}
