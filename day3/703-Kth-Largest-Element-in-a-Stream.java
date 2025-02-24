import java.util.PriorityQueue;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] a) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(); // Corrected initialization

        for (int num : a) {
            add(num); // Use add() method to maintain heap correctly
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val); // Add directly if heap has space
        } else if (val > minHeap.peek()) {
            minHeap.poll(); // Remove the k-th largest element (smallest in heap)
            minHeap.offer(val); // Insert the new value
        }
        return minHeap.peek(); // Return the k-th largest element
    }
}
