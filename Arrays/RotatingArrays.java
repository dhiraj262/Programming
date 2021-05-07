import java.util.Scanner;

/*
Rotating of arrays by d positons.
*/
public class RotatingArrays{

    //Approach 1: Using extra space by introducing a temperory varaiable.
    // Time complexity = O(n+d) , space complexity = O(d)
    public static void  rotateArrayUsingTemp(int[] arr,int n,int d){

        int[] temp = new int[d];
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }
        //shifting the elements to d position in arr
        for(int i=0;i<n-d;i++){
            arr[i]=arr[i+d];
        }
        //adding the elements from temp array again to the original array.
        int j=0;
        for(int i=n-d;i<n;i++){
            arr[i] = temp[j++];
        }
    }

    //Approach 2: Rotating the array 1 by 1.
    //Time complexity =O(n*d), space =O(1).
    public static void rotateArray1By1(int[] arr, int n ){
        int temp = arr[0];
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i+1];
        }
        arr[n-1] = temp;
    }
    public static void rotateArrayApproach2(int[] arr, int n, int d){
        for(int i=0;i<d;i++){
            rotateArray1By1(arr, n);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,d;
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        d=sc.nextInt();
        //printing the rotated array.
        //rotateArrayUsingTemp(arr, n, d);
        rotateArrayApproach2(arr, n, d);
        for(int i=0;i<n;i++){
            System.out.printf(arr[i]+" ");
        }
    }
}