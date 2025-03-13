package competition.leetcode.week440;

public class NumOfPlacedFruits {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;
        boolean[] placed = new boolean[baskets.length];
        for (int i = 0; i < fruits.length; i++) {
            boolean canBePlaced = false;
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j] && !placed[j]) {
                    placed[j] = true;
                    canBePlaced = true;
                    break;
                }
            }
            if (!canBePlaced) {
                unplaced++;
            }
        }


        return unplaced;
    }

    public static void main(String[] args) {
        NumOfPlacedFruits so = new NumOfPlacedFruits();
        int[] fruits = new int[]{4, 2, 5};
        int[] baskets = new int[]{3, 5, 4};
        int i = so.numOfUnplacedFruits(fruits, baskets);
        System.out.println(i);
    }
}
