import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
The hallway has N+2 tiles numbered from 0 to N+1 from left to right. There is a hole on tile number x. You hit the ball standing on tile 0. When you hit the ball, it bounces at lengths of k, i.e. the tiles covered by it are 0,k,2k,…, and so on until the ball passes tile N+1.

If the ball doesn't enter the hole in the first trial, you try again but this time standing on the tile N+1. When you hit the ball, it bounces at lengths of k, i.e. the tiles covered by it are (N+1),(N+1−k),(N+1−2k),…, and so on until the ball passes tile 0.

Find if the ball will enter the hole, either in its forward journey or backward journey.
*/
public class Golf {
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }

    }
    public static void main(String args[]){
        //Scanner sc = new Scanner(System.in);
        FastReader fs  = new FastReader();
        int t = fs.nextInt();
        while(t-->0){
            int n = fs.nextInt();
            int x = fs.nextInt();
            int k = fs.nextInt();
            String ans = "NO";
            for(int i=0;i<=n+1;i+=k){
                System.out.printf(i+" ");
                if(x==i){
                    
                    ans = "YES";
                }
            }
            for(int i=n+1;i>=0;i-=k){
                System.out.printf(i+" ");
                if(x==i){
                    
                    ans="YES";
                }
            }
            System.out.println(ans);
        }
    }
}
//Optimized solution without for loops:
// if (x%k==0) for forward pass as if it divides then only it is going in the hole.
//if((n+1-x)%k==0) for backward pass as if the distance between x and n+1 is divisible by k then only hole will be available.


