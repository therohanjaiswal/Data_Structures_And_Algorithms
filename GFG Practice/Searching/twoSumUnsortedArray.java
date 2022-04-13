// https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
// Approach 1: TC: O(n^2), SC: O(1)
// Approach 2: TC: O(n), SC: O(n)

import java.util.HashSet;

class Solution {
    public static boolean findPair1(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println("Index Pair: " + i + " & " + j);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findPair2(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if (set.contains(diff))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 9, 2, 8, 10, 11 };
        int sum = 17;
        System.out.println(findPair2(arr, sum));
    }
}
