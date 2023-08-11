package question3;

public class heap {
        private int[] heap;
        private int size;
        private int capacity;

        public heap(int capacity) {
            this.heap = new int[capacity];
            this.size = 0;
            this.capacity = capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void insert(int key) {
            if (isFull()) {
                throw new IllegalStateException("Priority queue is full.");
            }

            heap[size] = key;
            int index = size;
            size++;

            while (index > 0 && heap[index] > heap[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }

        public int extractMax() {
            if (isEmpty()) {
                throw new IllegalStateException("Priority queue is empty.");
            }

            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            maxHeapify(0);
            return max;
        }

        private void maxHeapify(int index) {
            int left = leftChild(index);
            int right = rightChild(index);
            int largest = index;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                maxHeapify(largest);
            }
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public static void main(String[] args) {
            heap maxHeap = new heap(10);
            maxHeap.insert(15);
            maxHeap.insert(10);
            maxHeap.insert(20);
            maxHeap.insert(5);

            while (!maxHeap.isEmpty()) {
                System.out.println(maxHeap.extractMax());
            }
        }
    }

    
