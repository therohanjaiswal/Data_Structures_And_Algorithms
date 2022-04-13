// https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
// Approach 1: Naive, TC: O(n.k), SC: O(1)
// Approach 2: Using Sliding Window Technique, TC: O(n), SC: O(1)

class Solution {
    public static int getMaxSum2(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return -1;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int getMaxSum(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return -1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 30, -5, 20, 7 };
        int k = 3;
        int result = getMaxSum(arr, k);
        System.out.println(result);
    }
}