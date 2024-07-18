package karlCodeTraining.D10String.RightRotateString55KM;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String string = "";
        while (scanner.hasNext()) {
            num = scanner.nextInt();
            string = scanner.next();
        }
//        String string = "abcdefg";
//        int num = 3;
        String ans = betterRightRotate(string, num);
        System.out.println(ans);


    }

    private static String rightRotate(String string, int num) {
        while (num > string.length()) {
            num -= string.length();
        }

        char[] arr = string.toCharArray();
        int rightExchangePointer = string.length() - num;
        while (rightExchangePointer > 0) {
            int newRightExchangePointer = rightExchangePointer - num;
            if (newRightExchangePointer >= 0) {
                int leftExchangePointer = newRightExchangePointer;
                for (int i = 0; i < num; i++) {
                    swap(arr, leftExchangePointer++, rightExchangePointer++);
                }
            } else {
                newRightExchangePointer = rightExchangePointer - 1;
                int leftExchangePointer = newRightExchangePointer;
                for (int i = 0; i < num; i++) {
                    swap(arr, leftExchangePointer++, rightExchangePointer++);
                }
            }
            rightExchangePointer = newRightExchangePointer;

        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();

    }

    /**
     * a b c d e f g
     * g f e d c b a
     * |-1|----2----|
     * f g a b c d e
     * @param string
     * @param num
     * @return
     */
    private static String betterRightRotate(String string, int num) {
        // first rotate all, then rotate each part
        char[] arr = string.toCharArray();
        reverseInRange(arr, 0, arr.length - 1);
        reverseInRange(arr, 0, num - 1);
        reverseInRange(arr, num, arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void reverseInRange(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
    private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
