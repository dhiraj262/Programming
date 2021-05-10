import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :

let x be the sum of all elements currently in your array.
choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
You may repeat this procedure as many times as needed.
Return True if it is possible to construct the target array from A otherwise return False.
*/
public class TargetArray{
    
    //Naive approach: TLE for larger numbers as complexity :O(n2)
    public static int indexOfIntArray(int[] array, int key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
          }
         return returnvalue;
        }
        public boolean isPossible(int[] target) {
            
            while(target.length<Arrays.stream(target).sum()){
                int max = Arrays.stream(target).max().getAsInt();
                int position = indexOfIntArray(target,max);
                target[position]  = 2*max - Arrays.stream(target).sum();
                if(target.length==Arrays.stream(target).sum())
                    return true;
                 
            }
            return false;
        }
        //Using priority queue.
        public static boolean isPossibleApproach2(int[] target){
            //Using comparator to arrange from max to min in priority queue.
            Queue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
            int sum=0;
            for(int num:target){
                sum +=num;
                priorityQueue.add(num);
            }
            System.out.println(priorityQueue);
            while(priorityQueue.peek()!=1){
                int num = priorityQueue.poll();
                sum-=num;
                if(num<sum || sum<1) return false;
                num %=sum;
                sum+=num;
                priorityQueue.add(num> 0?num:sum);
                System.out.println(priorityQueue);
            }
            return true;
        }
    public static void main(String[] args) {
        int[] target = {9,3,5};
        System.out.println(isPossibleApproach2(target));
    }
}