class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int dp[][]=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(i==0)                   //first row
                    dp[i][j]=matrix[i][j];
				else if(j==0)              // first column - minimum of top or top-diagonal-right
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j==matrix.length-1)       //last column -minimum of top or top-left-diagonal
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                else             //minimum number on top or top-left diagonal or top-right diagonal
                    dp[i][j]=matrix[i][j]+Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
            }
        }
        int min=Integer.MAX_VALUE;
		for(int j=0;j<matrix.length;j++)               //minimum - last row
            min=Math.min(dp[matrix.length-1][j],min);
        return min;
    }
}