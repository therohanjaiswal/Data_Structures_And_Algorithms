import java.util.Arrays;

public class Solution {
    static final int CHAR = 256;

    public static int leftMost(String str) {
        int res = Integer.MAX_VALUE;
        int[] count = new int[CHAR];
        Arrays.fill(count, -1);
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == -1)
                count[str.charAt(i)] = i;
            else
                res = Math.min(res, count[str.charAt(i)]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int bruteForce(String str) {
        for (int i = 0; i < str.length(); ++i)
            for (int j = i + 1; j < str.length(); ++j)
                if (str.charAt(i) == str.charAt(j))
                    return i;

        return -1;
    }

    public static void main(String[] args) {
        String str = "abccbd";
        System.out.println(leftMost(str));
        System.out.println(bruteForce(str));
    }
}
