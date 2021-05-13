import java.util.Scanner;

/*
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/

public class RangeSumQuery {

    // Time complexity : O(nm) , space:O(1)
    public static int rangeSum(int[][] matrix, int row1,int col1,int row2,int col2){

        int sum=0;
        for(int i=row1;i<=row2;i++){
            for(int j=col1;j<=col2;j++){
                sum+=matrix[i][j];
            }
        }
        return sum;
    }

    //Using Caching Rows technique (DP). calculate the sum of rows and store them.
    //Time complexity : O(N) for query , O(nm) for pre-computation, for calculating dp array.
    //Space Complexity : O(nm).
    public static int rangeSumDP(int[][] matrix, int row1,int col1,int row2,int col2){

        int sum=0;        
        int[][] dp = new int[matrix.length][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j+1] = dp[i][j] + matrix[i][j];
            }
        }

        for(int i=row1;i<=row2;i++){
            sum+=dp[i][col2+1] - dp[i][col1]; 
        }
        return sum;
    }
    
    //approach : SUM(ABCD) Using pre-computed cumulative region.
    //sum(ABCD) = sum(OD) - sum(OB) - sum(OC) + sum(OA) 
    //Time Complexity : O(1) query , O(nm) for dp array.
    //space complexity: O(nm).
    public static int rangeSumDPCummulativeSum(int[][] matrix, int row1,int col1,int row2,int col2){

            
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i+1][j+1] = dp[i][j+1] +dp[i+1][j]+ matrix[i][j] - dp[i][j];
            }
        }

        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int row2 = sc.nextInt();
        int col2 = sc.nextInt();

        System.out.println(rangeSum(matrix, row1, col1, row2, col2));
        System.out.println(rangeSumDP(matrix, row1, col1, row2, col2));
        System.out.println(rangeSumDPCummulativeSum(matrix, row1, col1, row2, col2));
    }
    
}
