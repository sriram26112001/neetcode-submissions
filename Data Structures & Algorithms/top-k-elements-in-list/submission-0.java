class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> freq.get(b) - freq.get(a));
        for(int num :freq.keySet())
        {
            maxHeap.offer(num);
        }
        while(k > 0 && !maxHeap.isEmpty())
        {
            ans.add(maxHeap.poll());
            k--;
        }
        int[] freqElements = new int[ans.size()];
        for(int i = 0;i < ans.size() ;i ++)
        {
            freqElements[i] = ans.get(i);
        }
        return freqElements;
    }
}
