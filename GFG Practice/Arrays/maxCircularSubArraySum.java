// https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
// Approach 1: TC: O(n^2), SC: O(1)
// Approach 2: Using Kadane's Algoritm, TC: O(n), SC: O(1)

class Solution {
    public static int normalMaxSum(int[] arr) {
        int maxSum = arr[0];
        int currSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(currSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static int getMaxCircularSum2(int[] arr) {
        int maxNormal = normalMaxSum(arr);
        if (maxNormal < 0)
            return maxNormal;
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }
        int circularSum = arrSum + normalMaxSum(arr);
        return Math.max(maxNormal, circularSum);
    }

    public static int getMaxCircularSum(int[] arr) {
        int n = arr.length;
        int maxCircularSum = arr[0];
        for (int i = 0; i < n; i++) {
            int currMax = arr[i];
            int currSum = arr[i];
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                currSum += arr[index];
                currMax = Math.max(currSum, currMax);
            }
            maxCircularSum = Math.max(maxCircularSum, currMax);
        }
        return maxCircularSum;
    }

    public static void main(String[] args) {
        int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
        int maxCircularSum = getMaxCircularSum2(arr);
        System.out.println("Maximum circular sum: " + maxCircularSum);
    }
}
