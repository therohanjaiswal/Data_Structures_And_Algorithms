// https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
// https://www.geeksforgeeks.org/minimum-number-of-replacements-to-make-the-binary-string-alternating-set-2/
// TC: O(n), SC: O(1) for both

class Solution {
    // Utility method to flip a character
    public static char flip(char ch) {
        return (ch == '0') ? '1' : '0';
    }

    // Utility method to get minimum flips when
    // alternate string starts with expected char
    public static int getFlipWithStartingCharcter(String str, char expected) {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++) {
            // if current character is not expected,
            // increase flip count
            if (str.charAt(i) != expected)
                flipCount++;

            // flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }

    public static int getMinFlipsToMakeAlternative(String s) {
        // return minimum of following two
        // 1) flips when alternate string starts with 0
        // 2) flips when alternate string starts with 1
        return Math.min(getFlipWithStartingCharcter(s, '0'), getFlipWithStartingCharcter(s, '1'));
    }

    public static int getMinFlipsToMakeAlternative2(String s) {
        int n = s.length();
        int flips = 0;
        for (int i = 0; i < n; i++) {
            // If there is 1 at even index positions
            if (i % 2 == 0 && s.charAt(i) == '1')
                ++flips;

            // If there is 0 at odd index positions
            if (i % 2 == 1 && s.charAt(i) == '0')
                ++flips;
        }
        return Math.min(flips, n - flips);
    }

    public static void main(String[] args) {
        String s = "1100";
        int res = getMinFlipsToMakeAlternative2(s);
        System.out.println("Min Flips: " + res);
    }
}
