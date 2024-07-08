package competition.leetcode.week396.validWord;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidWord {
}

class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E'));
        boolean containVowel = false;
        boolean containConsonant = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (vowels.contains(Character.toLowerCase(c))) {
                    containVowel = true;
                } else {
                    containConsonant = true;
                }
            } else {
                return false;
            }
        }
        return containConsonant && containVowel;
    }
}
