package karlCodeTraining.D29Greedy.LemonadeChange860;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] bills = new int[]{5,5,10,10,20};
        System.out.println(s.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[3];
        for (int i = 0; i < bills.length; i++) {
            int toChange = bills[i] - 5;
            if (bills[i] == 5) {
                cash[0]++;
                continue;
            }
            if (bills[i] == 10) {
                cash[1]++;
            }
            while (toChange != 0) {
                if (toChange == 5 && cash[0] == 0) {
                    return false;
                } else if (toChange == 5) {
                    cash[0]--;
                    toChange -= 5;
                } else {
                    if (cash[1] > 0) {
                        cash[1]--;
                        toChange  -= 10;
                    } else if (cash[0] > 0) {
                        cash[0]--;
                        toChange -= 5;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
