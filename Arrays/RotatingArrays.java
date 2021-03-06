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

    //Approach 3: extra array to place the element at (i+d)%length.
    //Time complexity : O(n) , space complexity : O(n).
    public static int[] rotate(int[] nums, int d) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
          a[(i + d) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
          nums[i] = a[i];
        }
        return nums;
      }

    //Approach 4: Reversing the array. Reversing the first part till n-d-1, then reversing the send part from n-d to n-1, at the end reversing the whole array.
    // Time complexity =O(n-d)+O(d)+O(n-1) = O(n) , space comexity = O(1).
    public static void reverse(int[] arr,int start,int end){
        int temp;
        int n=start+end;
        for(int i=start;i<n/2;i++){
            //swapping elements from first and last position.
            temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
    public static void reverseApproachRotateArray(int[] arr, int n,int d){
        d=d%n;
        reverse(arr, 0, n-d);
        reverse(arr, n-d,n);
        reverse(arr,0,n);
    }

    //Approach 5: using cyclic replacements:
    //Time complexity : O(n)  , space complexity : O(1).
    public static void cyclicReplacements(int[] arr, int d){
        int n = arr.length;
        d=d%n;
        int count=0;
        for(int i=0;count<n;i++){
            int current = i;
            int prev = arr[i];
            do{
                int next = (current+d)%n;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(i!=current);
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
        //rotateArrayApproach2(arr, n, d);
        //reverseApproachRotateArray(arr, n, d);
        cyclicReplacements(arr, d);
        for(int i=0;i<n;i++){
            System.out.printf(arr[i]+" ");
        }
    }
}