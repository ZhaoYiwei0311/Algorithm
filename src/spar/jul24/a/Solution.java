package spar.jul24.a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        String[] firstLineParams = firstLine.split(" ");
        String[] secondLineParams = secondLine.split(" ");

        int[] files = new int[secondLineParams.length];
        for (int i = 0; i < secondLineParams.length; i++) {
            files[i] = Integer.valueOf(secondLineParams[i]);
        }

        int total = Integer.valueOf(firstLineParams[1]) + Integer.valueOf(firstLineParams[2]);
        Arrays.sort(files);
        int sum = 0;
        int max = 0;
        for (int i = files.length - 1; i >= 0; i--) {
            if (i >= files.length - total) {
                max += files[i];
            }
            sum += files[i];
        }
        double ans = max * 1.0 / sum * 100;
        System.out.println(ans);
    }
}
