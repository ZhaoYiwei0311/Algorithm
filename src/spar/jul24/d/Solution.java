package spar.jul24.d;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int lines = Integer.valueOf(firstLine.split(" ")[0]);
        int counts = Integer.valueOf(firstLine.split(" ")[1]);
        String[] names = new String[lines];
        for (int i = 0; i < lines; i++) {
            names[i] = scanner.nextLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts; i++) {
            int[] map = new int[26];
            for (int j = 0; j < lines; j++) {
                char c = names[j].charAt(i);
                map[c - 'a']++;
            }
            char mostFromMap = getMostFromMap(map);
            sb.append(mostFromMap);
        }
        System.out.println(sb.toString());

    }

    private static char getMostFromMap(int[] arr) {
        int max = -1;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ans = i;
            }
        }
        return (char)(ans + 'a');
    }

}
