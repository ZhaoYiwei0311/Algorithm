package karlCodeTraining.D7HashTable.RansomNote383;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabets = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alphabets[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (alphabets[ransomNote.charAt(i) - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
