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
        System.out.println(Arrays.toString(nationalTeam));
    }

    public static int[] mergeAll(int[][] teams) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].length > 0) {
                minHeap.offer(new Element(teams[i][0], i, 0));
            }
        }

        int[] result = new int[10];
        int index = 0;

        while (!minHeap.isEmpty() && index < 10) {
            Element current = minHeap.poll();
            result[index++] = current.value;

            if (current.indexInArray + 1 < teams[current.arrayIndex].length) {
                minHeap.offer(new Element(
                        teams[current.arrayIndex][current.indexInArray + 1],
                        current.arrayIndex,
                        current.indexInArray + 1
                ));
            }
        }

        return result;
    }

    static class Element {
        int value;
        int arrayIndex;
        int indexInArray;

        public Element(int value, int arrayIndex, int indexInArray) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.indexInArray = indexInArray;
        }
    }
}