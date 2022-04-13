// return index of largest element in the array
// TC : O(n)
public class Solution {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 12, 5, 6 };
        System.out.println(largestElement(arr));
    }

    public static int largestElement(int[] arr) {
        int max = Integer.MIN_VALUE, index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
