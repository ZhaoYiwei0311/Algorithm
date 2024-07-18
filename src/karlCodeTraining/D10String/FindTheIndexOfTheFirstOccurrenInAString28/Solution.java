package karlCodeTraining.D10String.FindTheIndexOfTheFirstOccurrenInAString28;

public class Solution {

    public static void main(String[] args) {
        String h = "sadbutsad";
        String n = "aabaaf";
        Solution s = new Solution();
        s.strStr(h, n);

    }
    public int strStr(String haystack, String needle) {



        int[] needleArr = new int[needle.length()];

        for (int curPoint = 0; curPoint < needle.length(); curPoint++) {
            int left = 0;
            while (left < curPoint) {
                if (needle.charAt(curPoint) != needle.charAt(left)) {
                    needleArr[curPoint] = needleArr[left];
                    break;
                } else {
                    needleArr[curPoint] = left;
                    left++;
                    curPoint--;
                }
            }
        }

        for (int i = 0; i < needleArr.length; i++) {
            System.out.println(needleArr[i] + " ");
        }
        return 0;

    }
}
