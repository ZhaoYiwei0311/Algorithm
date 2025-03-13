package hot100.P4SubArray.Q3MinimumWindowSubstring;

public class Q76MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        char[] sChar = s.toCharArray();
        int ansLeft = -1;
        int ansRight = s.length();

        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            cntS[sChar[right]]++;
            while (isCovered(cntS, cntT)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[sChar[left]]--;
                left++;
            }
        }

        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }

    public String betterMinWindow(String s, String t) {
        char[] sChar = s.toCharArray();
        int ansLeft = -1;
        int ansRight = s.length();
        int[] cnt = new int[128];

        int less = 0;
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) {
                less++;
            }
            cnt[c]++;
        }

        int left = 0;
        for (int right = 0; right < t.length(); right++) {
            char c = sChar[right];
            cnt[c]--;
            if (cnt[c] == 0) {
                less--;
            }
            while (less == 0) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                char x = sChar[left];
                if (cnt[x] == 0) {
                    less++;
                }
                cnt[x]++;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}
