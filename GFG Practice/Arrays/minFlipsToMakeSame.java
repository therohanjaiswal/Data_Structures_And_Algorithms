// https://www.geeksforgeeks.org/minimum-group-flips-to-make-binary-array-elements-same/
// TC: O(n), SC: O(1)

class Solution {
    public static int getMinFlips(int[] arr) {
        int n = arr.length;
        int minFlips = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0])
                    System.out.print("From " + i + " to ");
                else {
                    System.out.println(i - 1);
                    ++minFlips;
                }
            }
        }
        if (arr[n - 1] != arr[0])
            System.out.println(n - 1);
        return minFlips;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1 };
        int res = getMinFlips(arr);
        System.out.println("Min Flips: " + res);
    }
}
