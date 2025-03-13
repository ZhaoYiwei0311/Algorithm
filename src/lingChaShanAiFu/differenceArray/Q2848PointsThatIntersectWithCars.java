package lingChaShanAiFu.differenceArray;

import java.util.List;
import java.util.Map;

public class Q2848PointsThatIntersectWithCars {

    public int numberOfPoints(List<List<Integer>> nums) {

        int maxDistance = 0;
        for (List<Integer> num : nums) {
            maxDistance = Math.max(num.get(1), maxDistance);
        }
        int[] diff = new int[maxDistance + 2];
        for (List<Integer> num : nums) {
            int l = num.get(0);
            int r = num.get(1);
            diff[l] += 1;
            diff[r + 1] -= 1;
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= maxDistance; i++) {
            sum += diff[i];
            if (sum > 0) {
                count++;
            }
        }
        return count;
    }
}
