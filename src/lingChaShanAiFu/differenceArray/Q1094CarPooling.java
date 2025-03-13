package lingChaShanAiFu.differenceArray;

public class Q1094CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxDistance = 0;
        for (int[] trip : trips) {
            int dest = trip[2];
            maxDistance = Math.max(dest, maxDistance);
        }
        int[] diffTrip = new int[maxDistance + 2];
        for (int[] trip : trips) {
            int passengers = trip[0], from = trip[1], dest = trip[2];
            diffTrip[from] += passengers;
            diffTrip[dest] -= passengers;
        }

        int sumD = 0;
        for (int i : diffTrip) {
            sumD += i;
            if (capacity - sumD < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q1094CarPooling so = new Q1094CarPooling();
        int[][] trips = new int[][]{{2,1,5}, {3,5,7}};
        int capacity = 3;
        boolean b = so.carPooling(trips, capacity);
        System.out.println(b);
    }
}
