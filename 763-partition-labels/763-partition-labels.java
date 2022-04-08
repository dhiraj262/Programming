class Solution {
    public List<Integer> partitionLabels(String s) {
        //Greedy
        
        List<Integer> res = new ArrayList();
        int[] last = new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i) - 'a'] = i; // a:9 , b:6 , c:8
        }
        
        int j=0, pivot = 0;
        for(int i=0;i<s.length();i++){
            j = Math.max(j , last[s.charAt(i) - 'a']);  // j=9
            if(i==j) {
                res.add(i - pivot +1);
                pivot = i +1;
            }
        }
        return res;
    }
}