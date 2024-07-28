package karlCodeTraining.D24BackTrack.RestoreIPAddress93;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String ip = "101023";
//        String ip = "0000";

        List<String> strings = s.restoreIpAddresses(ip);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int startIndex) {
        if (path.size() == 4) {
            res.add(getIpFromList(path));
            return;
        }

        for (int i = startIndex; i < startIndex + 3 && i < s.length(); i++) {
            if (s.length() - i - 1> (4 - path.size() - 1) * 3) {
                continue;
            }
            if (s.length() - i < 4 - path.size() - 1) {
                break;
            }
            if (Integer.valueOf(s.substring(startIndex, i + 1)) > 255) {
                continue;
            }
            if (s.charAt(startIndex) == '0' && i - startIndex > 0) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            backtrack(s, i + 1);
            path.removeLast();
        }
    }

    private String getIpFromList(List<String> ipPath) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ipPath.size(); i++) {
            sb.append(ipPath.get(i));
            if (i != ipPath.size() - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
