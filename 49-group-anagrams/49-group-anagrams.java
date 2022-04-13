class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return List.of();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] ch = new char[26];
            // character count
            for (char c : s.toCharArray()) ch[c - 'a']++;
            
            String keyStr = String.valueOf(ch); 
            //same character count for anagrams
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}