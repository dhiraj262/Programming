class Solution {
    public int threeSumMulti(int[] arr, int target) {
        // Like 3sum
        int MOD = (int)(1e9+7);   // 1_000_000_007
        long res = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; ++i) {
            int currTarget = target - arr[i];
            
            int j = i+1, k = arr.length - 1;
            // 2 pointer sum
            while (j < k) {
                
                if (arr[j] + arr[k] < currTarget)
                    j++;
                else if (arr[j] + arr[k] > currTarget)
                    k--;
                else if (arr[j] != arr[k]) {   //  A[j] + A[k] == currTarget.
                    
                    int left = 1, right = 1;  // counting the similar
                    while (j+1 < k && arr[j] == arr[j+1]) {
                        left++;
                        j++;
                    }
                    while (k-1 > j && arr[k] == arr[k-1]) {
                        right++;
                        k--;
                    }

                    res += left * right;
                    res %= MOD;
                    j++;
                    k--;
                } else {
                    res += (k-j+1) * (k-j) / 2;
                    res %= MOD;
                    break;
                }
            }
        }

        return (int) res;
    }
}