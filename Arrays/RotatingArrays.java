import java.util.Scanner;

/*
Rotating of arrays by d positons.
*/
public class RotatingArrays{

    //Approach 1: Using extra space by introducing a temperory varaiable.
    public static void  rotateArrayUsingTemp(int[] arr,int n,int d){

        int[] temp = new int[d];
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }
        //shifting the elements to d position in arr
        for(int i=0;i<n-d+1;i++){
            arr[i]=arr[i+d];
        }
        //adding the elements from temp array again to the original array.
        int j=0;
        for(int i=n-d+1;i<n;i++){
            arr[i] = temp[j++];
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
        rotateArrayUsingTemp(arr, n, d);
        for(int i=0;i<n;i++){
            System.out.printf(arr[i]+" ");
        }
    }
}