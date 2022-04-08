class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] pArray=pattern.toCharArray();
        
        String[] words=s.split(" ");
        if(pArray.length!=words.length || s.isEmpty()) return false;
        
        
        HashMap<Character, String> map=new HashMap<>();
        
        for(int i=0;i<words.length;i++)
        {
            if(!map.containsKey(pArray[i]) && !map.containsValue(words[i]))
            {
                map.put(pArray[i],words[i]);
            }
            
            if((!map.containsKey(pArray[i]) && map.containsValue(words[i]))
              || (!map.get(pArray[i]).equals(words[i])))
            {
                return false;
            }
            
        }
        
    return true;    
    }
}