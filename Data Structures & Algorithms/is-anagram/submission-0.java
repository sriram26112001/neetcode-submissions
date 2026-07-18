class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sfreq = new int[26];
        int[] tfreq = new int[26];
        for(int i=0;i<s.length();i++)
        {
            sfreq[s.charAt(i) - 97]++;
        }
        for(int i=0;i<t.length();i++)
        {
            tfreq[t.charAt(i) - 97]++;
        }
        return Arrays.equals(sfreq,tfreq);
    }
}
