class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] expectedFrequency = new int[26];
        int[] windowFrequency = new int[26];
        for(int i = 0;i < s1.length();i++)
        {
            expectedFrequency[s1.charAt(i) - 'a']++;
        }
        //Sliding Window Algorithm
        int i = 0,j = 0;
        while(j < s2.length())
        {
            windowFrequency[s2.charAt(j) - 'a']++;
            if(j - i + 1 == s1.length())
            {
                if(Arrays.equals(expectedFrequency,windowFrequency))
                {
                    return true;
                }
                windowFrequency[s2.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return false;
    }
}
