// https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
// TC: O(logn), SC: O(1)

class Solution {
    private static int findPos(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            // if left half is sorted
            if (arr[low] < arr[mid]) {
                if (x >= arr[low] && x <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else { // if right half is sorted
                if (x >= arr[mid] && x <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 200, 300, 10, 30, 40 };
        int x = 10;
        System.out.println(findPos(arr, x));
    }
}
