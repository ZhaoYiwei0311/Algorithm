package karlCodeTraining.D9String.ReverseWordsInAString151;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "   a good   example";
//        String[] s1 = ss.split(" ");
//        for (String string : s1) {
//            System.out.println(string);
//        }
        System.out.println(s.twoPointerRemoveSpacesInWords(ss));
    }

    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if ("".equals(arr[i].trim())) {
                continue;
            }
            sb.append(arr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String harderReverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                sb.append(arr[i]);
                if (i == arr.length - 1) {
                    stack.push(sb.toString());
                }
            } else {
                if (i > 0 && arr[i - 1] == ' ') {
                    continue;
                } else {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                    stack.push(" ");
                }
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String popped = stack.pop();
            sb.append(popped);
        }
        return sb.toString();
    }

    public String twoPointerRemoveSpacesInWords(String s) {
        char[] originalArr = s.toCharArray();
        int slow = 0;
        int fast = 0;

        while (fast < originalArr.length) {
            if (originalArr[fast] != ' ') {
                originalArr[slow] = originalArr[fast];
                slow++;
                fast++;
            } else {
                if ((fast > 0 && originalArr[fast - 1] == ' ') || slow == 0 && originalArr[fast] == ' ') {
                    fast++;
                } else {
                    originalArr[slow] = originalArr[fast];
                    slow++;
                    fast++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < slow; i++) {
            sb.append(originalArr[i]);
        }
        return sb.toString();
    }
}
