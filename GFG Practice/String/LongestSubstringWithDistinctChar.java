// https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/

import java.util.Arrays;

public class Solution {
    static final int CHAR = 256;

    // TC: O(n^3)
    public static int naiveApproach(String str) {
        int maxLen = 1;
        for (int i = 0; i < str.length(); ++i) {
            for (int j = i + 1; j < str.length(); ++j) {
                if (isDistinct(str, i, j))
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static boolean isDistinct(String str, int i, int j) {
        boolean[] vis = new boolean[CHAR];
        Arrays.fill(vis, false);
        for (int k = i; k <= j; ++k) {
            if (vis[str.charAt(k)] == true)
                return false;
            vis[str.charAt(k)] = true;
        }
        return true;
    }

    // TC: O(n^2)
    public static int betterApproach(String str) {
        int maxLen = 0;
        boolean[] vis = new boolean[CHAR];
        for (int i = 0; i < str.length(); ++i) {
            Arrays.fill(vis, false);
            for (int j = i; j < str.length(); ++j) {
                if (vis[str.charAt(j)] == true)
                    break;
                vis[str.charAt(j)] = true;
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // TC: O(n), my approach
    public static int efficientApproach1(String str) {
        int maxEnd = 1;
        int result = maxEnd;
        int[] prev = new int[CHAR];
        Arrays.fill(prev, -1);
        prev[str.charAt(0)] = 0;
        for (int i = 1; i < str.length(); ++i) {
            if (prev[str.charAt(i)] == -1) {
                maxEnd = maxEnd + 1;
                prev[str.charAt(i)] = i;
            } else {
                maxEnd = i - prev[str.charAt(i)];
            }
            result = Math.max(result, maxEnd);
        }
        return result;
    }

    // TC: O(n)
    public static int efficientApproach2(String str) {
        int result = 0;
        int[] prev = new int[CHAR];
        Arrays.fill(prev, -1);
        int start = 0;
        for (int end = 0; end < str.length(); ++end) {
            start = Math.max(start, prev[str.charAt(end)] + 1);
            int maxEnd = end - start + 1;
            result = Math.max(result, maxEnd);
            prev[str.charAt(end)] = end;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abcdabc";
        System.out.println("Substring length: " + naiveApproach(str));
        System.out.println("Substring length: " + betterApproach(str));
        System.out.println("Substring length: " + efficientApproach1(str));
        System.out.println("Substring length: " + efficientApproach2(str));
        // System.out.print(isDistinct(str, 0, str.length() - 1));
    }
}
