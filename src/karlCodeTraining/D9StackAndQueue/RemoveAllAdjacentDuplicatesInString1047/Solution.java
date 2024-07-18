package karlCodeTraining.D9StackAndQueue.RemoveAllAdjacentDuplicatesInString1047;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char cc = stack.pop();
                if (cc == c) {
                    continue;
                } else {
                    stack.push(cc);
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
