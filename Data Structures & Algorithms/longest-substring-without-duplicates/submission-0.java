class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxlength = 0;
        while(j < s.length())
        {
            while(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }
            int length = j-i+1;
            maxlength = Math.max(length,maxlength);
            set.add(s.charAt(j));
            j++;
        }
        return maxlength;
    }
}
