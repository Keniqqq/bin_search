import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                { 45, 31, 24, 22, 20, 17, 14, 13, 12, 10 },
                { 31, 18, 15, 12, 10, 8, 6, 4, 2, 1 },
                { 51, 30, 10, 9, 8, 7, 6, 5, 2, 1 }
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    public static int[] mergeAll(int[][] teams) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(10);

        for (int[] team : teams) {
            for (int rating : team) {
                minHeap.offer(rating);
                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        int[] result = new int[10];
        int index = 9;

        while (!minHeap.isEmpty()) {
            result[index--] = minHeap.poll();
        }

        return result;
    }
}