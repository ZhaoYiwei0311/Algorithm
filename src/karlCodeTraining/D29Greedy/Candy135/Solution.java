package karlCodeTraining.D29Greedy.Candy135;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ratings = new int[]{1,3,4,5,2};
        System.out.println(s.candy(ratings));;
    }
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;

        // From left to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        // From right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
//            } else {
//                candies[i] = candies[i + 1] - 1 == 0 ? 1 : candies[i + 1] - 1;
//            }
                }
        }

        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

}
