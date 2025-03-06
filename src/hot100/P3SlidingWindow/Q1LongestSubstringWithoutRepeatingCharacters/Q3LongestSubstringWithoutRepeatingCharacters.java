package hot100.P3SlidingWindow.Q1LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < charArray.length) {
            if (!map.containsKey(charArray[right]) || map.get(charArray[right]) < left) {
                ans = Math.max(right - left + 1, ans);
            } else {
                left = map.get(charArray[right]) + 1;
            }
            map.put(charArray[right], right);

            right++;
        }
        return ans;
    }

    /**
     * Better solution
     * @param S
     * @return
     */
    public int lengthOfLongestSubstring2(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        int left = 0;
        boolean[] has = new boolean[128];
        for (int right = 0; right < n; right++) {
            char c = s[right];
            // If window has contained c, including c will result in duplicate
            // So we need to remove c by moving left
            while (has[c]) { // Window still contains c
                has[s[left]] = false;
                left++; // make window smaller
            }
            has[c] = true; // add c
            ans = Math.max(ans, right - left + 1); // update
        }
        return ans;
    }


    public static void main(String[] args) {
        Q3LongestSubstringWithoutRepeatingCharacters s = new Q3LongestSubstringWithoutRepeatingCharacters();
        int i = s.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(i);
    }
}
