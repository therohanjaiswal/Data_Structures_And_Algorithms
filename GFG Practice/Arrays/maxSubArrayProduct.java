
// https://www.youtube.com/watch?v=jzQ-f2uU0UU
class Solution {
    // TC: O(n^2), SC: O(1)
    public static int maxSubarrayProductNaive(int[] arr) {
        int result = Integer.MIN_VALUE;
        int product;
        for (int i = 0; i < arr.length; ++i) {
            product = 1;
            for (int j = i; j < arr.length; ++j) {
                product *= arr[j];
                result = Math.max(result, product);
            }
        }
        return result;
    }

    // TC: O(n), SC: O(1)
    public static int maxSubarrayProductEfficient(int[] arr) {
        int product = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            product *= arr[i];
            result = Math.max(product, result);
            // product becomes 0 when arr[i] = 0
            if (product == 0)
                product = 1;
        }

        product = 1;
        for (int i = arr.length - 1; i >= 0; --i) {
            product *= arr[i];
            result = Math.max(product, result);
            // product becomes 0 when arr[i] = 0
            if (product == 0)
                product = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 6, -3, -10, 0, 2 };
        System.out.println(maxSubarrayProductNaive(arr));
        System.out.println(maxSubarrayProductEfficient(arr));
    }
}
