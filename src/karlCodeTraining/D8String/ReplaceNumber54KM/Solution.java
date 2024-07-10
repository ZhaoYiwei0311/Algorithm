package karlCodeTraining.D8String.ReplaceNumber54KM;

public class Solution {

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                sb.append("number");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
