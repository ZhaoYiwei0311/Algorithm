package karlCodeTraining.D34DP.UniquePathII63;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] og = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(s.uniquePathsWithObstacles(og));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int height = obstacleGrid.length;
        int[][] arr = new int[height][width];
        for (int i = 0; i < width; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                arr[0][i] = 1;
            }
        }

        for (int i = 0; i < height; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                arr[i][0] = 1;
            }
        }
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < height; j++) {
                if (obstacleGrid[j][i] == 1) {
                    arr[j][i] = 0;
                } else {
                    arr[j][i] = arr[j - 1][i] + arr[j][i - 1];
                }
            }
        }
        return arr[height - 1][width - 1];

    }
}
