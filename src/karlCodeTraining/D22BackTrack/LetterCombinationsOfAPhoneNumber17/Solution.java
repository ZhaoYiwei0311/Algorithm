package karlCodeTraining.D22BackTrack.LetterCombinationsOfAPhoneNumber17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
    private Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return res;
        }
        initializeMap();
        backtrack(digits, 0);
        return res;
    }

    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    private void backtrack(String input, int startIndex) {
        if (startIndex == input.length()) {
            res.add(sb.toString());
            return;
        }
        char currentInputChar = input.charAt(startIndex);
        String backupChars = map.get(currentInputChar);
        for (int i = 0; i < backupChars.length(); i++) {
            sb.append(backupChars.charAt(i));
            backtrack(input, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private void initializeMap() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
