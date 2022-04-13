import java.util.Stack;

class Solution {
    public static void nextGreater(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(arr[n - 1]);
        int nextGreater = -1;
        System.out.print(nextGreater + " ");
        for (int i = n - 2; i >= 0; --i) {
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            nextGreater = st.isEmpty() ? -1 : st.peek();
            System.out.print(nextGreater + " ");
            st.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 15, 10, 8, 6, 12, 9, 18 };
        nextGreater(arr);
    }
}