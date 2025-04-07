import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        compare(1);
        compare(2);
        compare(5);
        compare(15);
    }

    public static void compare(int day) {
        System.out.println("=== Day " + day + " ===");
        int[] startNumbers = { 21, 1, 20, 23 };
        int iterative = chooseHobbyIterative(startNumbers, day);
        int recursive = chooseHobbyRecursive(startNumbers, day);
        System.out.println("Iterative = " + iterative + " | Recursive = " + recursive);
        System.out.println();
    }

    public static int chooseHobbyRecursive(int[] startNumbers, int day) {

        int[] dp = new int[day + 4];

        for (int i = 0; i < 4; i++) {
            dp[i] = startNumbers[i];
        }
        return helper(dp, day + 3);
    }

    private static int helper(int[] dp, int index) {
        if (dp[index] != 0) {
            return dp[index];
        }

        int prev = helper(dp, index - 1);
        int prePrePrev = helper(dp, index - 3);

        dp[index] = (prev * prePrePrev) % 10 + 1;

        return dp[index];
    }

    public static int chooseHobbyIterative(int[] startNumbers, int day) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(startNumbers[0]);
        numbers.add(startNumbers[1]);
        numbers.add(startNumbers[2]);
        numbers.add(startNumbers[3]);

        for (int d = 0; d < day; d++) {
            int index = d + 4;
            int prev = numbers.get(index - 1);
            int prePrePrev = numbers.get(index - 3);
            numbers.add((prev * prePrePrev) % 10 + 1);
        }

        return numbers.get(numbers.size() - 1);
    }
}