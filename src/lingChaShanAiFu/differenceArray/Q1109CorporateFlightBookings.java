package lingChaShanAiFu.differenceArray;

public class Q1109CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];
        for (int[] booking : bookings) {
            int l = booking[0];
            int r = booking[1];
            int seats = booking[2];
            diff[l] += seats;
            diff[r + 1] -= seats;
        }
        int[] ans = new int[n];
        int sumD = 0;
        for (int i = 1; i <= n; i++) {
            sumD += diff[i];
            ans[i - 1] = sumD;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] bookings = new int[][]{{1,2,10}, {2,3,20}, {2,5,25}};
        int n = 5;
        Q1109CorporateFlightBookings so = new Q1109CorporateFlightBookings();
        int[] ints = so.corpFlightBookings(bookings, n);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
