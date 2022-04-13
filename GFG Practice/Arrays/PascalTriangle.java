
// https://www.geeksforgeeks.org/pascal-triangle/
import java.util.ArrayList;

class Solution {
    // TC: O(n^2), Sc: O(n^2)
    public static ArrayList<Long> nthRowOfPascalsTriangle(int n) {
        ArrayList<Long> res = new ArrayList<>();
        int[][] arr = new int[n][n];
        int line;
        for (line = 0; line < n; ++line) {
            for (int col = 0; col <= line; ++col) {
                if (col == 0 || col == line)
                    arr[line][col] = 1;
                else
                    // mod1000000007 is done to avoid overflow
                    arr[line][col] = (arr[line - 1][col - 1] + arr[line - 1][col]) % 1000000007;
            }
        }

        line = n - 1;
        for (int col = 0; col <= line; ++col)
            res.add((long) arr[line][col]);
        return res;
    }

    public static void main(String[] args) {
        int row = 4;
        ArrayList<Long> res = nthRowOfPascalsTriangle(row);
        System.out.print(res);
    }
}