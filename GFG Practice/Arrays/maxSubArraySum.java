// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
class Solution {
    // TC: O(n^2), SC: O(1)
    public static int getMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Kadane's Algorithm: TC: O(n), SC: O(1)
    public static int getMaxSum2(int[] arr) {
        int maxSum = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            maxSum = Math.max(maxEnding, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { -5, 1, -2, 3, -1, 2, -2 };
        int result = getMaxSum(arr);
        System.out.println("Max Subarray sum: " + result);
    }
}
