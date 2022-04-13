import java.util.Stack;

public class Solution {
    public static int largestRecAreaEfficient(int[] arr) {

    }

    // TC: O(n), SC:O(n), with three array traversal and two aux stacks
    public static int largestRecAreaBetter(int[] arr) {
        int[] prevSmallest = computePrevSmallest(arr);
        int[] nextSmallest = computeNextSmallest(arr);
        int maxRecArea = Integer.MIN_VALUE, curr;
        for (int i = 0; i < arr.length; ++i) {
            curr = arr[i];
            curr += (i - prevSmallest[i] - 1) * arr[i];
            curr += (nextSmallest[i] - i - 1) * arr[i];
            maxRecArea = Math.max(maxRecArea, curr);
        }
        return maxRecArea;
    }

    public static int[] computePrevSmallest(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] prevSm = new int[arr.length];
        prevSm[0] = -1;
        st.push(0);
        for (int i = 1; i < arr.length; ++i) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            prevSm[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return prevSm;
    }

    public static int[] computeNextSmallest(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nextSm = new int[n];
        nextSm[n - 1] = n;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; --i) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            nextSm[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nextSm;
    }

    // TC: O(n^2), with two array traversal
    public static int largestRecAreaNaive(int[] arr) {
        int maxRecArea = arr[0];
        int start, end, area, j;
        for (int i = 1; i < arr.length; ++i) {
            area = 0;
            j = i - 1;
            while (j >= 0 && arr[j] >= arr[i])
                --j;
            start = j + 1;

            j = i + 1;
            while (j < arr.length && arr[j] >= arr[i])
                ++j;
            end = j - 1;
            area = (end - start + 1) * arr[i];
            maxRecArea = Math.max(maxRecArea, area);
        }
        return maxRecArea;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 5, 4, 1, 5, 6 };
        // int[] arr = { 2, 5, 1 };
        System.out.println(largestRecAreaBetter(arr));
    }
}
