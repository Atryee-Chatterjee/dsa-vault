/*
Problem: Connect N Ropes with Minimum Cost

Approach:
- Use a min priority queue to store all rope lengths
- Add all rope lengths to the priority queue
- Remove the two smallest ropes from the queue
- Connect them and calculate the cost
- Add the cost to the total cost
- Insert the newly connected rope back into the queue
- Repeat until only one rope remains

Complexity:
Time: O(n log n)
Space: O(n)

Key Idea:
- Greedily connect the two smallest ropes first
- A min priority queue always provides the two smallest rope lengths
- Repeating this process minimizes the total connection cost
*/
package Queues;

import java.util.PriorityQueue;

public class ConnectNRopes {

    public static int minCost(int arr[], int n) {
        // Create a min priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all rope lengths to the queue
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int totalCost = 0;

        // Connect the two smallest ropes until one remains
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;
            totalCost += cost;

            pq.add(cost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        int n = arr.length;

        System.out.println("Minimum cost: " + minCost(arr, n));
    }
}
