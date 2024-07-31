package spar.jul31.e;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String lowerCase = firstLine.toLowerCase();


        if (lowerCase.contains("sss")) {
            System.out.println(lowerCase);
            String replace = lowerCase.replace("sss", "Bs");
            System.out.println(replace);
            replace = lowerCase.replace("sss", "sB");
            System.out.println(replace);
            return;
        }

        if (lowerCase.contains("ss")) {
            System.out.println(lowerCase);
            String replace = lowerCase.replace("ss", "B");
            System.out.println(replace);
            return;
        }

        System.out.println(lowerCase);
    }
}
