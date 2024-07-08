package karlCodeTraining.D5HashTable.HappyNumber202;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> duplicate = new HashSet<>();
        int number = n;
        while (!duplicate.contains(number)) {
            duplicate.add(number);

            int sum = 0;
            while (number != 0) {
                int digit = number % 10;
                number = number / 10;
                sum += digit * digit;
            }
            if (sum == 1) {
                return true;
            }
            number = sum;
        }
        return false;
    }
}
