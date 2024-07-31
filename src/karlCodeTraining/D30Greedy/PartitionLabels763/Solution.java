package karlCodeTraining.D30Greedy.PartitionLabels763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String st = "vhaagbqkaq";
        List<Integer> integers = s.partitionLabels(st);
        for (Integer i : integers) {
            System.out.println(i);
        }

    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int lastIndex = 0;
        int[] lastOccurrence = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[chars[i] - 'a'] = i;
        }
        int curOccur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            int lastOccur = lastOccurrence[c - 'a'];
            curOccur = Math.max(lastOccur, curOccur);
            if (curOccur == i) {
                res.add(i - lastIndex + 1);
                lastIndex = i + 1;
            }
        }
        return res;
    }
}
