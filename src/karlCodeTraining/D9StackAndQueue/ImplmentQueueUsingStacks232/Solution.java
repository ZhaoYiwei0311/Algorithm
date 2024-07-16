package karlCodeTraining.D9StackAndQueue.ImplmentQueueUsingStacks232;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
}

class MyQueue {

    private Deque<Integer> stackIn;
    private Deque<Integer> stackOut;

    public MyQueue() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {

        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        int res = stackOut.pop();
        return res;
    }

    public int peek() {
        int popped = pop();
        stackOut.push(popped);
        return popped;
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}
