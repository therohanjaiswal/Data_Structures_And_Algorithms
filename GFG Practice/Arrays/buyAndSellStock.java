// https://www.geeksforgeeks.org/stock-buy-sell/
// TC: O(n), SC: O(1)

class Solution {
    public static int findMaxProfit(int[] arr, int start, int end) {
        if (end <= start)
            return 0;
        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (arr[j] > arr[i]) {
                    int curr_profit = arr[j] - arr[i] + findMaxProfit(arr, start, i - 1)
                            + findMaxProfit(arr, j + 1, end);
                    profit = Math.max(curr_profit, profit);
                }
            }
        }
        return profit;
    }

    public static int findMaxProfit2(int[] arr) {
        int buy = -1, sell = -1;
        int profit = 0, i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (buy == -1)
                    buy = i - 1;
                profit += arr[i] - arr[i - 1];
            } else if (arr[i] < arr[i - 1]) {
                if (buy != -1) {
                    sell = i - 1;
                    System.out.println(buy + " - " + sell);
                    buy = sell = -1;
                }
            }
        }

        if (buy != -1) {
            sell = i - 1;
            System.out.println(buy + " - " + sell);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 1, 2, 8 };
        // int maxProfit = findMaxProfit(arr, 0, arr.length - 1);
        int maxProfit = findMaxProfit2(arr);
        System.out.println("Max profit - " + maxProfit);
    }
}
