import java.util.Stack;

// TC: Push: O(1), Pop: O(1), getMin: O(1), SC: O(1)
class SpecialStack2 extends Stack<Integer> {
    int min = -1;

    void push(int val) {
        if (isEmpty()) {
            min = val;
            super.push(val);
        } else if (val <= min) {
            super.push(2 * val - min);
            min = val;
        } else {
            super.push(val);
        }
    }

    public Integer pop() {
        int x = super.pop();
        if (x <= min) {
            int res = min;
            min = 2 * min - x;
            return res;
        }
        return x;
    }

    Integer getMin() {
        return min;
    }

    public Integer peek() {
        if (super.peek() <= 0)
            return min;
        return super.peek();
    }
}
