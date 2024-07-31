package karlCodeTraining.D29Greedy.QueueReconstructionByHeight406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {


    // First sort by height
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // sequence asc
            } else {
                return b[0] - a[0]; // height desc
            }
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1], p);   //Linkedlist.add(index, value)
        }

        return que.toArray(new int[people.length][]);
    }

}
