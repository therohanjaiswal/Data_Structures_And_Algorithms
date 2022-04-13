// https://www.geeksforgeeks.org/subarray-of-size-k-with-given-sum/
// Approach: Sliding Window Technique, TC: O(n), SC: O(1)

class Solution {
    public static boolean findSubarray(int[] arr, int k, int sum) {
        int currSum = 0;
        for (int i = 0; i < k; i++)
            currSum += arr[i];

        if (currSum == sum)
            return true;

        for (int i = k; i < arr.length; i++) {
            currSum += arr[i] - arr[i - k];
            if (currSum == sum)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 30, -5, 20, 7 };
        int k = 2, sum = 27;
        System.out.println(findSubarray(arr, k, sum));
    }
}
