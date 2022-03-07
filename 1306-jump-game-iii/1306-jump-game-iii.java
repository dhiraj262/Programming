class Solution {
    public boolean canReach(int[] arr, int start) {
        //BFS APPROACH :
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);  // add the start in queue
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            if(arr[curr] == 0) return true;
            
            if(arr[curr] < 0) continue;
            
            if(curr + arr[curr] < arr.length){
                queue.add(curr+arr[curr]);
            } 
            if(curr - arr[curr] >=0){
                queue.add(curr - arr[curr]);
            }
            
            arr[curr] = -arr[curr];  // to mark it visited.
        }
        return false;
    }
    
}