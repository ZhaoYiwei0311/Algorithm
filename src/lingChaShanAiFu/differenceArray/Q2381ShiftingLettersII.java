package lingChaShanAiFu.differenceArray;

public class Q2381ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int l = shift[0], r = shift[1], d = shift[2];
            if (d == 0) {
                diff[l]--;
                diff[r + 1]++;
            } else {
                diff[l]++;
                diff[r + 1]--;
            }
        }
        char[] charArray = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < diff.length - 1; i++) {
            sum += diff[i];
            char c = charArray[i];

            // tricky trick
            charArray[i] = (char)((c - 'a' + (sum % 26) + 26) % 26 + 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Q2381ShiftingLettersII so = new Q2381ShiftingLettersII();
        String s = "dztz";
        int[][] shifts = new int[][]{{0,0,0}, {1,1,1}};
        String string = so.shiftingLetters(s, shifts);
        System.out.println(string);
    }
}
