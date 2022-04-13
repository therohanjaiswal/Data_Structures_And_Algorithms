public class Solution {
    public static void naiveSearch2(String str, String pattern) {
        int n = str.length(), m = pattern.length();
        for (int i = 0; i < n - m + 1; ++i) {
            int j;
            for (j = 0; j < m; ++j) {
                if (str.charAt(i + j) != pattern.charAt(j)) {
                    i = i + j - 1;
                    break;
                }
            }
            if (j == m) {
                System.out.println(i);
                i = i + j - 1;
            }

        }
    }

    // TC: O((n - m + 1) * m), This works for all cases
    public static void naiveSearch(String str, String pattern) {
        int n = str.length(), m = pattern.length();
        for (int i = 0; i < n - m + 1; ++i) {
            int j;
            for (j = 0; j < m; ++j)
                if (str.charAt(i + j) != pattern.charAt(j))
                    break;

            if (j == m)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        String str = "ABCABCDABCD";
        String pattern = "ABCD";
        naiveSearch(str, pattern);
        naiveSearch2(str, pattern);
    }
}
