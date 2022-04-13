class Solution {
    public static boolean isPalindrome(String str) {
        int low = 0, high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return false;
            ++low;
            --high;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcdcba";
        if (isPalindrome(str))
            System.out.print(str + " is palindrome");
        else
            System.out.print(str + " is not palindrome");
    }
}