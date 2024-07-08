package karlCodeTraining.D2Array.SpiralMatrixII59;

class Solution {


    public static void main(String[] args) {

        Solution s = new Solution();
        int n = 3;
        int[][] ints = s.generateMatrix(n);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.println(ints[i][j]);
            }
            System.out.println("---");
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int loopCount = n / 2 + 1;

        int num = 1;
        for (int curLoop = 0; curLoop < loopCount; curLoop++) {
            
            int start = curLoop;
            
            int eachLoopCount = n - curLoop * 2 - 1;

            // up
            for (int i = 0; i < eachLoopCount; i++) {
                ans[start][start + i] = num++;
            }

            int rightRowStart = start;
            int rightColStart = start + eachLoopCount;

            for (int i = 0; i < eachLoopCount; i++) {
                ans[rightRowStart + i][rightColStart] = num++;
            }

            int bottomRowStart = start + eachLoopCount;
            int bottomColStart = start + eachLoopCount;

            for (int i = 0; i < eachLoopCount; i++) {
                ans[bottomRowStart][bottomColStart - i] = num++;
            }

            int leftRowStart = start + eachLoopCount;
            int leftColStart = start;

            for (int i = 0; i < eachLoopCount; i++) {
                ans[leftRowStart - i][leftColStart] = num++;
            }
            
        }


        // need to independently assign center is n is odd
        if (n % 2 == 1) {
            ans[n / 2][n / 2] = num;
        }

        return ans;
    }
}
