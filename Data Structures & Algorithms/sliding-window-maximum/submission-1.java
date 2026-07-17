class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int p = 0;
        int i = 0,j = 0;
        // Sliding Window Algorithm
        while (j < nums.length)
        {
            while(!d.isEmpty() && nums[j] > nums[d.peekLast()])
            {
                d.removeLast();
            }
            d.addLast(j);
            if(!d.isEmpty() && j - i + 1 == k)
            {
                ans[p++] = nums[d.peekFirst()];
                if(i ==  d.peekFirst())
                {
                    d.removeFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
