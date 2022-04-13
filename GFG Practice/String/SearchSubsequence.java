public class Solution {
    public static boolean isSubsequence(String str, String target) {
        if (target.length() == 0) // empty string is always a subsequence
            return true;

        if (str.length() == 0)
            return false;

        int i = 0, j = 0;
        while (i < str.length() && j < target.length()) {
            if (str.charAt(i) == target.charAt(j)) {
                ++i;
                ++j;
            } else
                ++i;

            if (j == target.length())
                return true;
        }
        return false;
    }

    public static boolean isSubsequenceRec(String str, String target, int i, int j) {
        if (target.length() == 0)
            return true;

        if (j == target.length())
            return true;
        if (str.charAt(i) == target.charAt(j))
            return isSubsequenceRec(str, target, ++i, ++j);
        return isSubsequenceRec(str, target, ++i, j);
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String target = "gksfs";
        if (isSubsequence(str, target))
            System.out.println(target + " is a subsequence");
        else
            System.out.println(target + " is not a subsequence");

        if (isSubsequenceRec(str, target, 0, 0))
            System.out.println(target + " is a subsequence");
        else
            System.out.println(target + " is not a subsequence");
    }
}
