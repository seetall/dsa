package question4;

import java.util.Collections;
import java.util.PriorityQueue;

public class a {
    public static void main(String[] args) {
        // Create a max priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add elements to the maxHeap
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(15);
        maxHeap.add(20);
        maxHeap.add(25);

        // Print the elements in descending order (max to min)
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }

}
