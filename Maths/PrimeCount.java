import java.util.Arrays;
import java.util.Scanner;

public class PrimeCount {
    //simple approach to find the prime number. Time complexity: O(n).
    public static boolean isPrimeSimple(int num){
        
        for(int i=2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    //Better approach is to loop until the square root of number and find if it is divisible by any of the numbers.
    public static boolean isPrimeApproach2(int num){
        
        for(int i=2;i*i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    //Sieve algo to find number of prime numbers efficiently. O(Nloglog(Sqrt(N))).
    public static int primeSeiveAlgo(int n){
        Boolean[] sieve = new Boolean[n];
        
        Arrays.fill(sieve, true);
        sieve[0]=sieve[1]=false;
        for(int i=2;i*i<n;i++){
            if(sieve[i]==true){
                //All multiples of the prime number be false
                for(int j=i*i;j<n;j+=i){
                    sieve[j]=false;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(sieve[i]) count++;
        }

        return count;
    }
    // we can also use segmented sieve for calculating prime in segments for very large numbers or in the range.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPrimeSimple(n));
        System.out.println(primeSeiveAlgo(n));
    }
}
