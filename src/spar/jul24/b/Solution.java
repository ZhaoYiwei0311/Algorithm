package spar.jul24.b;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();

        double leftHealth = Double.valueOf(firstLine);
        int count = 0;
        while (leftHealth > 0) {
            if (leftHealth / 2 > 1) {
                leftHealth = leftHealth / 2;
            } else {
                leftHealth -= 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
