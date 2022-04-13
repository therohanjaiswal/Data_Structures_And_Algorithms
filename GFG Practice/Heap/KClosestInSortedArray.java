
// https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
class Solution {
    public static void main(String[] args) {
        int[] arr = { 12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56 };
        int k = 4, x = 35;
        int[] res = findKClosest(arr, k, x);
        for (int i : res)
            System.out.print(i + " ");
    }

    // TC: O(logn + k), SC: O(1)
    public static int[] findKClosest(int[] arr, int k, int x) {
        int[] res = new int[k];
        int n = arr.length;
        int l = findCrossOverPoint(arr, 0, n - 1, x);
        int r = l + 1;
        int count = 0;

        // if x is present in the array, don't consider it
        if (arr[l] == x)
            l--;

        while (l >= 0 && r < n && count < k) {
            if (x - arr[l] < arr[r] - x)
                res[count++] = arr[l--];
            else
                res[count++] = arr[r++];
        }

        while (count < k && l >= 0)
            res[count++] = arr[l--];

        while (count < k && r < n)
            res[count++] = arr[r++];

        return res;
    }

    public static int findCrossOverPoint(int[] arr, int low, int high, int val) {
        if (arr[high] <= val)
            return high;
        if (arr[low] > val)
            return low;

        int mid = low + (high - low) / 2;

        // if val is not present in the array ie., say val = 15
        // and arr is [11, 13, 14, 17, 20], here index of 14 will be the cross point
        if (arr[mid] <= val && arr[mid + 1] > val)
            return mid;

        if (arr[mid] < val)
            return findCrossOverPoint(arr, mid + 1, high, val);
        return findCrossOverPoint(arr, low, mid - 1, val);
    }
}