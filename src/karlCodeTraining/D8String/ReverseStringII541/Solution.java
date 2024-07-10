package karlCodeTraining.D8String.ReverseStringII541;

public class Solution {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        Solution so = new Solution();
        System.out.println(so.betterReverseStr(s, k));

    }
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            if (chars.length - i < 2 * k && chars.length - i < k) {
                // reverse all left
                int j = i;
                while (j < (chars.length - i) / 2 + i) {
                    swap(chars, j, chars.length - 1 - (j - i));
                    j++;
                }
                break;
            } else if (chars.length - i < 2 * k && chars.length - i > k) {
                int j = i;
                while (j < i + k / 2) {
                    swap(chars, j, i + k - 1 - (j - i));
                    j++;
                }
                break;
            } else {
                int j = i;
                while (j < i + k / 2) {
                    swap(chars, j, i + k - 1 - (j - i));
                    j++;
                }
//                for (int j = i; j < (i + k) / 2; j++) {
//                    swap(chars, j, j + k - 1 - i);
//                }
                i += 2 * k;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    public String betterReverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k) {
            // jump 2 * k each time
            if (i + k <= chars.length) {
                // sufficient for swap
                reverse(chars, i, i + k);
                continue;
            }
            reverse(chars, i, chars.length);
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    private void reverse(char[] chars, int l, int r) {
        int s = l;
        while (s < l + (r - l) / 2) {
            swap(chars, s, r - (s - l) - 1);
            s++;
        }
    }

    private void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
}
