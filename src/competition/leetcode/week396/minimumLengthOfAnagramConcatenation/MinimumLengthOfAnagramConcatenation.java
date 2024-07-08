package competition.leetcode.week396.minimumLengthOfAnagramConcatenation;

public class MinimumLengthOfAnagramConcatenation {

}

class Solution {
    public int minAnagramLength(String s) {
        int[] count = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return 0;
    }
}
