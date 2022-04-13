
// https://www.geeksforgeeks.org/the-stock-span-problem/
import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class PrintSpan {
    public static void printSpan(int[] arr) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int span = 1;
        st.push(0);
        System.out.print(span + " ");
        for (int i = 1; i < arr.length; ++i) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();

            span = st.isEmpty() ? i + 1 : i - st.peek();
            System.out.print(span + " ");
            st.push(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 13, 15, 12, 14, 16, 8, 6, 4, 10, 30 };
        printSpan(arr);
    }
}
