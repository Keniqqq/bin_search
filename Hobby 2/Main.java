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
        int recursive = chooseHobbyRecursive(startNumbers, day);
        System.out.println("Recursive = " + recursive);
        System.out.println();
    }

    public static int chooseHobbyRecursive(int[] startNumbers, int day) {
        int[] dp = new int[day + 4];

        for (int i = 0; i < 4; i++) {
            dp[i] = startNumbers[i];
        }

        return computeRecursive(dp, day + 3);
    }

    private static int computeRecursive(int[] dp, int index) {

        if (dp[index] != 0) {
            return dp[index];
        }

        int prev = computeRecursive(dp, index - 1);
        int prePrePrev = computeRecursive(dp, index - 3);

        dp[index] = (prev * prePrePrev) % 10 + 1;

        return dp[index];
    }
}
