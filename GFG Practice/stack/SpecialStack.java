import java.util.Stack;

// TC: Push: O(1), Pop: O(1), getMin: O(1), SC: O(n)
class SpecialStack extends Stack<Integer> {
    Stack<Integer> minStack = new Stack<>();

    void push(int val) {
        if (isEmpty()) {
            super.push(val);
            minStack.push(val);
            return;
        }

        if (val < minStack.peek())
            minStack.push(val);
        super.push(val);
    }

    public Integer pop() {
        int x = super.pop();
        if (x == minStack.peek())
            minStack.pop();
        return x;
    }

    int getMin() {
        return minStack.peek();
    }
}
