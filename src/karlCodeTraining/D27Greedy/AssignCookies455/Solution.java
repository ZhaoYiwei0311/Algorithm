package karlCodeTraining.D27Greedy.AssignCookies455;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if (s.length == 0) {
            return 0;
        }
        int count = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (g[i] > s[index]) {
                continue;
            }
            count++;
            index--;
            if (index < 0) {
                break;
            }
        }
        return count;
    }
}
