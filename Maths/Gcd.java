import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Gcd {
    //Recursive 
    public static long gcd(long a, long b){
        
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
         BigInteger a = new BigInteger(br.readLine());
         BigInteger b = new BigInteger(br.readLine());
         System.out.println(a.gcd(b));
         System.out.println(gcd(3,397));
        
    }
    
}
