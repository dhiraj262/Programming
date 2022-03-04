class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] v = new boolean[rooms.size()];
        dfs(0,rooms, v);
        for(boolean visit: v){
            if(visit == false) return false;
        }
        return true;
    }
    
    private void dfs(int key,List<List<Integer>> rooms,boolean[] v){
        v[key] = true;
        for(int room : rooms.get(key)){
            if(v[room] == false){
                dfs(room , rooms, v);
            }
        }
    }
}