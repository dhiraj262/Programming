class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int longestSub = 0, start=0,val =0;
	    int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch))
                if (map.get(ch)>=start) {
                    val = i - start;
                    if (val > longestSub) {
                        longestSub = val;
                    }
                    start = map.get(ch) + 1;
            }
            map.put(ch, i);
        }
        if (longestSub < (len - start)) {
            longestSub = (len - start);
        }
	    return longestSub;
    }
}