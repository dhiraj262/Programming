import java.util.Scanner;

/*
Given height of n buildings, find out how many units of rain water can be stored in between the buildings.
Consider width of each building to be 1 unit.
*/

public class RainWater {
    
    //Solution 1: complexity time O(n^2) ; space O(1)
    public static int rainWaterApproach1(int[] arr, int n){
        //Brute force solution
        int water = 0;
        for(int i=0;i<n-1;i++){
            //Calcuting lmax and rmax for every iteration.
            int lmax = 0;
            int rmax=0;
            for(int j=i;j>=0;j--){
                if(arr[j]>lmax)
                    lmax = arr[j];
            }

            for(int j=i;j<n;j++){
                if(arr[j]>rmax)
                    rmax = arr[j];
            }

            water+=Math.min(lmax, rmax)-arr[i];
        }
        return water;
    }

    //approach 2:using extra space to store the lmax and rmax values.
    // Complexity time : O(n) ;space : O(n)

    public static int optimizedApproach2(int[] arr,int n){
        int water = 0;
        int leftArr[] = new int[n];
        int rightArr[] = new int[n];
        leftArr[0] = arr[0];
        rightArr[n-1] = arr[n-1];
        for(int i=1;i<n;i++){
            if(arr[i]>leftArr[i-1])
                leftArr[i]= arr[i];
            else
                leftArr[i] = leftArr[i-1];
        }

        for(int i=n-2;i>=0;i--){
            if(arr[i]>rightArr[i+1])
                rightArr[i]= arr[i];
            else
                rightArr[i] = rightArr[i+1];
        }

        for(int i=0;i<n;i++){
            water+=Math.min(leftArr[i],rightArr[i])-arr[i];
        }
        return water;
    }
    
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        //Array containing the height of the buildings.
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        //int water = rainWaterApproach1(arr, n);
        int water = optimizedApproach2(arr, n);
        System.out.println("The Rain water stored between the buildings is : "+water);
    }

}
