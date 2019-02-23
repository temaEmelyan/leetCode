package leetCode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class task787CheapestFlightWithKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] flight : flights) {
            Map<Integer, Integer> destinationPriceMap = graph.computeIfAbsent(flight[0], key -> new HashMap<>());

            int destination = flight[1];
            int price = flight[2];
            destinationPriceMap.put(destination, price);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(array -> array[0]));

        queue.add(new int[]{0, src, k + 1});

        while (!queue.isEmpty()) {
            int[] remove = queue.remove();

            int priceToGetHere = remove[0];
            int position = remove[1];
            int stopNumbersLeft = remove[2];

            if (position == dst) {
                return priceToGetHere;
            }
            if (stopNumbersLeft > 0) {
                Map<Integer, Integer> integerIntegerMap = graph.get(position);
                if (integerIntegerMap == null) {
                    continue;
                }
                for (Map.Entry<Integer, Integer> destinationPriceEntry : integerIntegerMap.entrySet()) {
                    int priceToGetThere = priceToGetHere + destinationPriceEntry.getValue();
                    queue.add(new int[]{priceToGetThere, destinationPriceEntry.getKey(), stopNumbersLeft - 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] i1 = {0, 1, 100};
        int[] i2 = {1, 2, 100};
        int[] i3 = {0, 2, 500};
        int[][] edges = new int[3][];
        edges[0] = i1;
        edges[1] = i2;
        edges[2] = i3;

        System.out.println(new task787CheapestFlightWithKStops().findCheapestPrice(3, edges, 0, 2, 0));
    }

}

