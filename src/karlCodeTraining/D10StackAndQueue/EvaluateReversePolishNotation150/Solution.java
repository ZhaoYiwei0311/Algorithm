package karlCodeTraining.D10StackAndQueue.EvaluateReversePolishNotation150;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int evalRPN(String[] tokens) {

        Deque<Integer> numStack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                numStack.push(numStack.pop() + numStack.pop());
            } else if ("-".equals(token)) {
                numStack.push(- numStack.pop() + numStack.pop());
            } else if ("*".equals(token)) {
                numStack.push(numStack.pop() * numStack.pop());
            } else if ("/".equals(token)){
                int after = numStack.pop();
                int before = numStack.pop();
                numStack.push(before / after);
            } else {
                Integer number = Integer.valueOf(token);
                numStack.push(number);
            }

        }
        return numStack.pop();
    }
}
