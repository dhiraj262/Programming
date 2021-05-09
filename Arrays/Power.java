import java.util.Scanner;

/*
For a given N, find the number of ways to choose an integer x from the range [0,pow(2,N)−1] such that x⊕(x+1)=(x+2)⊕(x+3), where ⊕ denotes the bitwise XOR operator.
solution: 1 contains 1 such x; 2 constains 2 such x; 3 constains 4 such x; 2^N / 2 = answer is pow(2,N-1).
*/

public class Power {

    public static long powerMod(long x, long y, long m){
        long result=1;
        
        while(y>0){
            if((y&1)!=0){
                result = result*x %m;
            }
            y=y>>1;
            x =  x*x %m;
        }
        return result;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc = new Scanner(System.in);
		long m = 1000000007L;
		int t = sc.nextInt();
		long ans;
		while(t-->0){
		    long n = sc.nextInt();
		    if(n==1){
		        ans = 1;
		    } else {
		        n=n-1;
		    ans = powerMod(2l,n,m);
		    }
		    System.out.println(ans);
		}
	}
}
