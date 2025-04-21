import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] teams = {
                { 45, 31, 24, 22, 20, 17, 14, 13, 12, 10 },
                { 31, 18, 15, 12, 10, 8, 6, 4, 2, 1 },
                { 51, 30, 10, 9, 8, 7, 6, 5, 2, 1 }
        };
        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam));
    }

    public static int[] mergeAll(int[][] teams) {
        int[] indices = new int[teams.length];
        int[] result = new int[10];
        int index = 0;

        while (index < 10) {
            int maxValue = Integer.MIN_VALUE;
            int maxArrayIndex = -1;

            for (int i = 0; i < teams.length; i++) {
                if (indices[i] < teams[i].length && teams[i][indices[i]] > maxValue) {
                    maxValue = teams[i][indices[i]];
                    maxArrayIndex = i;
                }
            }

            if (maxArrayIndex == -1) {
                break;
            }

            result[index++] = maxValue;
            indices[maxArrayIndex]++;
        }

        return result;
    }
}