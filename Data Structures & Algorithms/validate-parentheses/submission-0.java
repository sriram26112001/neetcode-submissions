class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i = 0; i <s.length();i++)
        {
            if(map.containsValue(s.charAt(i)))
            {
                st.push(s.charAt(i));
            }
            else if(map.containsKey(s.charAt(i)))
            {
                if(st.isEmpty() || !map.get(s.charAt(i)).equals(st.peek()))
                {
                    return false;
                }
                st.pop();
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}


