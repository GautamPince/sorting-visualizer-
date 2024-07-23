package sortingAlgorithm;

public class HeapSort extends SortAlgorithm {
    @Override
    public void sort(double[] array, long initial_speed) {
        super.sort(array, initial_speed);

        heapSort(array);

        sorting_panel.repaint();
    }

    private void heapSort(double[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            double temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Reduce the heap size by one
            int heapSize = i;
            heapify(array, heapSize, 0);

            // Repaint the panel and simulate delay
            try {
                current_index = 0;
                traversing_index = i;
                sorting_panel.repaint();
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void heapify(double[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // If left child is larger than root
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // If right child is larger than largest so far
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // If largest is not root
        if (largest != rootIndex) {
            double swap = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, heapSize, largest);
        }
    }
}
