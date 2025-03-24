public class Main {
    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length; // все недоступны
        }

        if (prices[prices.length - 1] <= money) {
            return 0; // все доступны
        }

        int left = 0;
        int right = prices.length - 1;
        int firstUnavailable = prices.length;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (prices[middle] > money) {
                firstUnavailable = middle;
                right = middle - 1; // ищем первый недоступный - двигаемся влево
            } else {
                left = middle + 1; // ищем в правой части
            }
        }

        return prices.length - firstUnavailable;
    }
}