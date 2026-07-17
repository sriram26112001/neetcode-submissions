class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0,highestFrequency = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0,j = 0;
        while(j < s.length())
        {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
            highestFrequency = Math.max(highestFrequency,map.get(s.charAt(j)));
            int num_of_character_replacement = (j - i + 1) - highestFrequency;
            if(num_of_character_replacement > k)
            {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) - 1);
                i++;
            }
            int length = j - i + 1;
            maxLength = Math.max(length,maxLength);
            j++;
        }
        return maxLength;
    }
}
