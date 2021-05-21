import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;
/*
Given integers N and M, find the number of ordered pairs (a,b) such that 1≤a<b≤N and ((M mod a) mod b)=((M mod b) mod a).
*/
public class ModularEquation {

	public static BigInteger modEqn(int n,int m){
		BigInteger[] modArray = new BigInteger[n+1];
		for(int i=0;i<=n;i++){
			modArray[i] = BigInteger.ONE;
		}
		BigInteger count=BigInteger.ZERO;
		    for(int i=2;i<=n;i++){
		    	int x = BigInteger.valueOf((long)m).mod(BigInteger.valueOf((long)i)).intValue();
			
			    count = count.add(modArray[x]);
			    for(int j=x;j<=n;j+=i){
				    modArray[j]= modArray[j].add(BigInteger.ONE);
			    }
		}
		return count;
	}

	public static long modEqn1(int n,int m){
		
		Long[] modArray = new Long[(int)n];
		Arrays.fill(modArray,1l);
		long count=0;
		for(long i=2;i<=n;i++){
			int x = (int)((long)m%i);
			count++;
			for(int j=x;j<=n;j+=i){
				modArray[j]++;
			}
		}
		return count;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    long count = 0;
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    for(int i=1;i<=n;i++){
		        for(int j=i+1;j<=n;j++){
		            if((m%i)%j == (m%j)%i){
                        //System.out.println(i + " "+ j);
                        
		                count++;
		            }
                }
		    }
		    System.out.println(count);
			System.out.println(modEqn(n, m));
		}
    }
}
