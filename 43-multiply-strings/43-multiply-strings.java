class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        int l1 = num1.length();
        int l2 = num2.length();
        
        int len = l1+l2;
        int[] product = new int[len];
        for(int i = l1-1;i>=0;i--){
            int a = num1.charAt(i) -'0';
            for(int j=l2-1;j>=0;j--){
                int b = num2.charAt(j) - '0';
                int index = i+j+1;
                int prod = a * b + product[index];
                product[index] = prod % 10;
                product[index-1] += prod/10;
                
            }
        }
        
        int start = product[0]!=0? 0:1;
        StringBuilder result = new StringBuilder();
        for(int i=start;i<len;i++){
            result.append(product[i]);
        }
        return result.toString();
    }
}