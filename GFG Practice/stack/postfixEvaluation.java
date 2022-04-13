
// https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
import java.util.*;

public class postfixEvaluation {
    public static int evaluatePostfix(String exp) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                st.push(c - '0'); // convert character to integer
            } else {
                int op2 = st.pop();
                int op1 = st.pop();
                if (c == '+')
                    st.push(op1 + op2);
                else if (c == '-')
                    st.push(op1 - op2);
                else if (c == '*')
                    st.push(op1 * op2);
                else if (c == '/')
                    st.push(op1 / op2);
                else if (c == '^')
                    st.push((int) Math.pow(op1, op2));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        int result = evaluatePostfix(exp);
        System.out.print(result);
    }
}
