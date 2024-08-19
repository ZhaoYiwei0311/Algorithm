package karlCodeTraining.D48MonotonicStack.DailyTemperatures739;


import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = solution.dailyTemperatures(temperatures);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int prevIndex = stack.peek();
                    int prevTemperature = temperatures[prevIndex];
                    if (prevTemperature < temperatures[i]) {
                        res[prevIndex] = i - prevIndex;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
