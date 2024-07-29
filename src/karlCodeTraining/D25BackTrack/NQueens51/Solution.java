package karlCodeTraining.D25BackTrack.NQueens51;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(n);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }


    List<List<String>> res = new ArrayList<>();
    int[][] grid;
    int putQueens = 0;

    public List<List<String>> solveNQueens(int n) {
        grid = new int[n][n];
        backtrack(0, n);
        return res;
    }

    private void backtrack(int row, int queens) {
        if (putQueens == queens) {
            res.add(gridToString());
            return;
        }

        for (int col = 0; col < queens; col++) {
            if (checkValid(row, col, queens)) {
                grid[row][col] = 1;
                putQueens++;
                backtrack(row + 1, queens);
                putQueens--;
                grid[row][col] = 0;
            }

        }
    }

    private List<String> gridToString() {
        List<String> res = new ArrayList<>();
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int col : ints) {
                if (col == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean checkValid(int row, int col, int queens) {
        if (grid[row][col] == 1) {
            return false;
        }
        for (int i = 0; i < queens; i++) {
            if (grid[row][i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < queens; i++) {
            if (grid[i][col] == 1) {
                return false;
            }
        }
        int tempRow = row;
        int tempCol = col;
        // right-down
        while (tempRow < queens && tempCol < queens) {
            if (grid[tempRow][tempCol] == 1) {
                return false;
            }
            tempRow++;
            tempCol++;
        }
        tempRow = row;
        tempCol = col;
        // right-up
        while (tempRow >= 0 && tempCol < queens) {
            if (grid[tempRow][tempCol] == 1) {
                return false;
            }
            tempRow--;
            tempCol++;
        }
        tempRow = row;
        tempCol = col;
        // left-down
        while (tempRow < queens && tempCol >= 0) {
            if (grid[tempRow][tempCol] == 1) {
                return false;
            }
            tempRow++;
            tempCol--;
        }
        tempRow = row;
        tempCol = col;
        // left-up
        while (tempRow >= 0 && tempCol >= 0) {
            if (grid[tempRow][tempCol] == 1) {
                return false;
            }
            tempRow--;
            tempCol--;
        }
        return true;
    }
}
