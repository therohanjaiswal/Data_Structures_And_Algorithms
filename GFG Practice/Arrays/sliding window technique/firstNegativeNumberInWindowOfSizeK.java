// https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
// Brute Force: TC: O(n^2), SC: O(1)
// Efficient: TC: O(n), SC: O(1)

import java.util.LinkedList;

class Solution {

    public static void bruteForce(int arr[], int n, int k) {
        boolean flag;
        for (int i = 0; i < (n - k + 1); i++) {
            flag = false;
            for (int j = 0; j < k; j++) {
                if (arr[i + j] < 0) {
                    System.out.print((arr[i + j]) + " ");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.print("0" + " ");
        }
    }

    public static void printFirstNegativeInteger(int arr[], int n, int k) {
        int start = 0, end;
        LinkedList<Integer> list = new LinkedList<>();

        for (end = 0; end < k - 1; end++)
            if (arr[end] < 0)
                list.add(end);

        for (; end < n; end++) {
            if (arr[end] < 0) {
                list.add(end);
            }

            if (list.size() == 0) {
                System.out.print(0 + " ");
            } else {
                System.out.print(arr[list.get(0)] + " ");
                if (arr[list.get(0)] == arr[start])
                    list.remove(0);
            }
            start++;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        bruteForce(arr, arr.length, k);
        System.out.println();
        printFirstNegativeInteger(arr, arr.length, k);
    }
}
