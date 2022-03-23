class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // treating the matrix as 1d array
        
        int n=matrix.length; 
        int m=matrix[0].length; 
        int left=0, right = n*m-1;
        int mid,midVal;
        
        // Since it is sorted we can apply binary search
        while(left<=right)
        {
            mid=left+(right-left)/2;
            midVal=matrix[mid/m][mid%m];
            if(midVal==target)
                return true;
            else if(target<=midVal)
                right=mid-1;
            else
                left=mid+1;

        }
        return false;

    }
}