// https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
class Solution {
    public static int findMaxDiff(int[] arr) {
        int curr_min = arr[0];
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff = Math.max(diff, arr[i] - curr_min);
            curr_min = Math.min(curr_min, arr[i]);
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
        // edge case: int[] arr = {30, 10, 8, 2} // decreasing order with max diff
        // present in middle of array i.e., 10 - 8 = -2
        int result = findMaxDiff(arr);
        System.out.println(result);
    }
}
