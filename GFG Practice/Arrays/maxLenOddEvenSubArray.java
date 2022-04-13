// https://www.geeksforgeeks.org/length-of-the-longest-alternating-even-odd-subarray/
// Approach 1 : TC: O(n^2), SC: O(1)
// Approach 2: Based of Kadane's algorithm. TC: O(n), SC: O(1)
class Solution {
    public static int maxOddEven2(int[] arr) {
        int maxSubarray = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 != 0 && arr[i - 1] % 2 == 0) || (arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)) {
                ++curr;
                maxSubarray = Math.max(maxSubarray, curr);
            } else
                curr = 1;

        }
        return maxSubarray;
    }

    public static int maxOddEven(int[] arr) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int curr = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] % 2 != 0 && arr[j - 1] % 2 == 0) || (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0))
                    ++curr;
                else
                    break;
            }
            maxSubarray = Math.max(maxSubarray, curr);
        }
        return maxSubarray;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 20, 6, 3, 8 };
        int result = maxOddEven2(arr);
        System.out.println(result);
    }
}
