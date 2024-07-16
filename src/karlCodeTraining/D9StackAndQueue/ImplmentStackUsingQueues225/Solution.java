package karlCodeTraining.D9StackAndQueue.ImplmentStackUsingQueues225;

import com.sun.tools.javac.Main;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.empty());


    }
}

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int ans = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            ans = queue.poll();
            if (i != size - 1) {
                queue.offer(ans);
            } else {
                break;
            }
        }
        return ans;
    }

    public int top() {
        int pop = pop();
        queue.offer(pop);
        return pop;

    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
