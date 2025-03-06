package hot100.P1Hash.Q2GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] alphabets = new int[26];
            String curString = strs[i];
            for (int j = 0; j < curString.length(); j++) {
                alphabets[curString.charAt(j) - 'a']++;
            }
            StringBuilder curStringRes = new StringBuilder();
            for (int k = 0; k < alphabets.length; k++) {
                curStringRes.append((char)(k + 'a')).append(alphabets[k]);
            }
            if (map.containsKey(curStringRes.toString())) {
                map.get(curStringRes.toString()).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(curStringRes.toString(), newList);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }

    public static void main(String[] args) {
        Q49Solution solution = new Q49Solution();

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String string : list) {
                System.out.print(string);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
