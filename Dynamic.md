- This file is for Dynamic Programming notes
1) Subsets : https://leetcode.com/problems/subsets/
```
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
```
2) Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/
```
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 
```
3) Permutations : https://leetcode.com/problems/permutations/
```
public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> curr, int [] nums){
   if(curr.size() == nums.length){
      list.add(new ArrayList<>(curr));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(curr.contains(nums[i])) continue; // element already exists, skip
         curr.add(nums[i]);
         backtrack(list, curr, nums);
         tempList.remove(curr.size() - 1);
      }
   }
} 
```
4) Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
```
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}
```
5) Combination Sum : https://leetcode.com/problems/combination-sum/
```
public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}
```
6) Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/
```
public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1); 
        }
    }
} 
```
7) Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/
```
public List<List<String>> partition(String s) {
   List<List<String>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), s, 0);
   return list;
}

public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
   if(start == s.length())
      list.add(new ArrayList<>(tempList));
   else{
      for(int i = start; i < s.length(); i++){
         if(isPalindrome(s, start, i)){
            tempList.add(s.substring(start, i + 1));
            backtrack(list, tempList, s, i + 1);
            tempList.remove(tempList.size() - 1);
         }
      }
   }
}

public boolean isPalindrome(String s, int low, int high){
   while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
   return true;
} 
```

 8) 122. Best Time to Buy and Sell Stock II

There are multiple ways to solve this question, but the most optimal one is this one-pass solution.

In this solution, we are trying to buy the stock if the previous day's price is lower than the current price. We will buy the stock at the previous price and sell it today to make a profit. If we repeat this for all such days (where the current price is higher than the previous day's price), we can add all the profits to get the total profit.

For example:
If Input is prices = [7,1,5,3,6,4]
Let us assume the day is represented by the array indexes.
Then on day 2, the current price is 5 and on the previous day (day 1) the price is 1. This matches our criteria. Profit will be 5-1 = 4.
Then on day 4, the current price is 6 and on the previous day (day 3) the price is 3. This matches our criteria. Profit will be 6-3 = 3.
No other pair of consecuitive days match the our crtiteria prices[i - 1] < prices[i]
Total Profit = 4 + 3 = 7.

Time Complexity: O(N) --> N is length of the input price array
Space Complexity: O(1) --> Constant Space
```
class Solution {
    public int maxProfit(int[] prices) {
		// We need prices for 2 days at least to find the profit.
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // Checking if we can profit with previous day's price.
            // If yes, then we buy on previous day and sell on current day.
            // Add all such profits to get the total profit.
            if (prices[i - 1] < prices[i]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }
}
```
9)  121. Best Time to Buy and Sell Stock

Time Complexity: O(N) --> N is length of the input price array
Space Complexity: O(1) --> Constant Space
```
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfitHere = 0;
        int maxProfitSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfitHere = Math.max(0, maxProfitHere + prices[i] - prices[i - 1]);
            maxProfitSoFar = Math.max(maxProfitSoFar, maxProfitHere);
        }

        return maxProfitSoFar;
    }
}
```
10) 123. Best Time to Buy and Sell Stock III

Time Complexity: O(N) --> N is length of the input price array
Space Complexity: O(1) --> Constant Space

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int buy1 = -prices[0];
        int sell1 = buy1 + prices[0];
        int buy2 = sell1 - prices[0];
        int sell2 = buy2 + prices[0];

        for (int i = 1; i < prices.length; i++) {
            // The maximum money left after buying 1st stock.
            buy1 = Math.max(buy1, -prices[i]);

            // The maximum money left after selling 1st stock.
            sell1 = Math.max(sell1, buy1 + prices[i]);

            // The maximum money left after buying 2nd stock.
            buy2 = Math.max(buy2, sell1 - prices[i]);

            // The maximum money left after selling 2nd stock.
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return Math.max(sell1, sell2);
    }
}

11) 188. Best Time to Buy and Sell Stock IV

Time Complexity: O(N * k)
Space Complexity: O(N) --> Space required for dp1 and dp2 arrays.
Where:
--> N is length of the input price array.
--> k is the input number representing maximum number of transactions.
```
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }

        int len = prices.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for (int i = 0; i < k; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < len; j++) {
                dp2[j] = Math.max(dp2[j - 1], prices[j] + tempMax);
                tempMax = Math.max(tempMax, dp1[j] - prices[j]);
            }
            dp1 = Arrays.copyOf(dp2, len);
        }

        return dp2[len - 1];
    }

    private int quickSolve(int[] prices) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }
}
```
12) 309. Best Time to Buy and Sell Stock with Cooldown

Time Complexity: O(N) --> N is length of the input price array
Space Complexity: O(1) --> Constant Space
```
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int buy = -prices[0];
        int sell = 0;
        int prevSell = 0;

        for (int i = 1; i < prices.length; i++) {
            // buy[i] = Math.max(sell[i-2]-prices[i], buy[i-1])
            // sell[i-2]-prices[i] -> Buy after a 1 day cooldown
            // buy[i-1] -> cooldown
            buy = Math.max(prevSell - prices[i], buy);

            // sell[i-1];
            prevSell = sell;

            // sell[i] = Math.max(buy[i]+prices, sell[i-1])
            // buy[i]+prices -> sell the stock.
            // sell[i-1] -> cooldown
            sell = Math.max(buy + prices[i], sell);
        }

        return sell;
    }
}
```
13) 714. Best Time to Buy and Sell Stock with Transaction Fee

Time Complexity: O(N) --> N is length of the input price array
Space Complexity: O(1) --> Constant Space
```
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {

            // buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i])
            buy = Math.max(sell - prices[i], buy);

            // sell[i] = Math.max(sell[i - 1], buy[i] + prices[i])
            sell = Math.max(buy + prices[i] - fee, sell);
        }

        return sell;
    }
}
```


Buy & Sell Stock Question	|  Time Complexity	| Space Complexity <br>
121. Best Time to Buy and Sell Stock	| O(N)	| O(1)<br>
122. Best Time to Buy and Sell Stock II	| O(N)	| O(1)<br>
123. Best Time to Buy and Sell Stock III	| O(N)	| O(1) <br>
188. Best Time to Buy and Sell Stock IV	 | O(N * k)	| O(N)  <br>
309. Best Time to Buy and Sell Stock with Cooldown	| O(N)	| O(1)<br>
714. Best Time to Buy and Sell Stock with Transaction Fee | O(N) | O(1)<br>
