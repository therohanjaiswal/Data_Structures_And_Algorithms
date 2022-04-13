// https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/

import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
    public static boolean isBalanced(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < str.length(); ++i) {
            if ((str.charAt(i) == '(') || (str.charAt(i) == '{') || (str.charAt(i) == '[')) {
                st.push(str.charAt(i));
            } else {
                if (st.isEmpty() || !isMatching(st.peek(), str.charAt(i)))
                    return false;
                else
                    st.pop();
            }
        }
        return st.isEmpty() ? true : false;
    }

    public static boolean isMatching(char a, char b) {
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }

    public static void main(String[] args) {
        String str = "{[()]}";
        if (isBalanced(str))
            System.out.println("Balanced");
        else
            System.out.println("Unbalanced.");
    }
}
