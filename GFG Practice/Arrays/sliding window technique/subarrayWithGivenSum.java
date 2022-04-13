// https://www.geeksforgeeks.org/find-subarray-with-given-sum/
// Appraoch: Sliding Window Technique, Array must contain non-negative integers
// TC: O(n), SC: O(1)
// Important!!!
class Solution {
    public static boolean findSubarray(int[] arr, int sum) {
        int currSum = arr[0];
        int n = arr.length;
        int start = 0;
        for (int end = 1; end <= n; end++) {
            while (currSum > sum && start < end - 1) {
                currSum -= arr[start];
                start++;
            }
            if (currSum == sum) {
                System.out.println("Sum found between indexes " + start + " and " + (end - 1));
                return true;
            }
            if (end < n)
                currSum += arr[end];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
                154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
        int sum = 468;
        System.out.println(findSubarray(arr, sum));
    }
}
