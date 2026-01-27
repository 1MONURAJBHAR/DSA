public class BuyAndSellStockDP {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int ans = findMaxProfit(arr);
        System.out.println("Max profit is: "+ans);
    }


    // Returns the maximum profit that can be achieved from one buy and one sell
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static int findMaxProfit(int[] arr) {
        int n = arr.length;

        // Maximum profit so far (0 because profit cannot be negative)
        int profit = 0;

        // Minimum price seen so far (initially the first day's price)
        int buy = arr[0];

        // Start from day 1 because we cannot sell before buying
        for (int sell = 1; sell < n; sell++) {

            // Profit if we sell on current day
            int cost = arr[sell] - buy;

            // Update maximum profit
            profit = Math.max(profit, cost);

            // Update minimum buying price
            buy = Math.min(buy, arr[sell]);
        }
        return profit;
    }


    /*static int findMaxProfit(int[] arr){
        int n = arr.length;
        int Profit = 0;
        int buy = arr[0];
        
        for (int sell = 1; sell < n; sell++){
            int cost = arr[sell]-buy;
            Profit = Math.max(Profit, cost);
            buy = Math.min(buy, arr[sell]);
        }
        return Profit;
    }*/
}
