// TC: O(n), SC: O(1)
class Solution {
    public static int findMaxConsOnes(int[] arr) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                ++count;
            else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int result = findMaxConsOnes(arr);
        System.out.println("Max consecutive ones: " + result);
    }
}