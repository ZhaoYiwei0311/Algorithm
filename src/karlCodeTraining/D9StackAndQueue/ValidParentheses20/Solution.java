package karlCodeTraining.D9StackAndQueue.ValidParentheses20;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "()";
        System.out.println(s.isValid(ss));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
                continue;
            } else if (c == '{') {
                stack.push('}');
                continue;

            } else if (c == '[') {
                stack.push(']');
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            char oc = stack.pop();
            if (c != oc) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
