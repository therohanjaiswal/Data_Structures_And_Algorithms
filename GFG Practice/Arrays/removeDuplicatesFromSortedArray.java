// https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
// TC: O(n), SC: O(1)
class Solution {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 1)
            return arr.length;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j] != arr[i])
                arr[++j] = arr[i];
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 5 };
        int n = arr.length;
        System.out.print("Original Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        n = removeDuplicates(arr);
        System.out.print("\nResultant Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
