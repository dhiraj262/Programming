class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
    int len=nums1.length-1;
        m-=1;
        n-=1;
    while(m>=0 && n>=0)
    {
        if(nums1[m]>nums2[n])
        {
            nums1[len]=nums1[m];
            len-=1;
            m-=1;
        }
            
        else
        {
            nums1[len]=nums2[n];
            len-=1;
            n-=1;
        }
            
    }
    
    while(m>=0)
         nums1[len--]= nums1[m--];
     while(n>=0)
         nums1[len--]=nums2[n--];
        
    
        
    }
}