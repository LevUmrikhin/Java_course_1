import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.UUID;

public class Main7 {
    public static void main(String[] args) {
        System.out.println("enter array: ");                // read the values for arrays and print them sorted.
        Scanner scanner = new Scanner(System.in);
        String array = scanner.nextLine();
        array = array.replaceAll("\\s+", "");
        String[] array1 = array.split(",");

        SortingAlgorithmImp array3 = new SortingAlgorithmImp(array1.clone());
        SortingAlgorithmImp1 array4 = new SortingAlgorithmImp1(array1.clone());
        array3.Sort();
        array4.Sort();
        System.out.println("Sorted array: " + array3);
        System.out.println(array4);
        scanner.close();

        String[] arr2 = new String[1000000];
        Random random = new Random();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = UUID.randomUUID().toString();
        }
        String [] arr3 = arr2.clone();
        SortingAlgorithmImp arr6 = new SortingAlgorithmImp(arr2);
        SortingAlgorithmImp1 arr7 = new SortingAlgorithmImp1(arr3);
        long a = System.currentTimeMillis();
        arr6.Sort();
        arr7.Sort();
        long b = System.currentTimeMillis();
        System.out.println(arr6);
        System.out.println(arr7);
        System.out.println(b-a);


    }
    public interface SortingAlgorithm {    //interface for sorting
        void Sort();
    }
    static class SortingAlgorithmImp implements SortingAlgorithm {

        private String[] arr;
        public SortingAlgorithmImp(String[] arr) { // Constructor to initialize array
            this.arr = arr;
        }


        @Override
        public void Sort() {
            int n = arr.length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

            // Extract elements from heap one by one
            for (int i = n - 1; i > 0; i--) {
                // Move current root to end
                String temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // Call max heapify on the reduced heap
                heapify(arr, i, 0);
            }
        }

        // Method to heapify a subtree rooted at node i
        void heapify(String[] arr, int n, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // left child
            int right = 2 * i + 2; // right child

            // If left child is larger than root
            if (left < n && arr[left].compareTo(arr[largest]) > 0)
                largest = left;

            // If right child is larger than largest so far
            if (right < n && arr[left].compareTo(arr[largest]) >0)
                largest = right;

            // If largest is not root
            if (largest != i) {
                String swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Recursively heapify the affected subtree
                heapify(arr, n, largest);
            }

        }
        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }

    static class SortingAlgorithmImp1 implements SortingAlgorithm {

        private String[] arr;
        public SortingAlgorithmImp1(String[] arr) { // Constructor to initialize array
            this.arr = arr;
        }

        @Override
            public void Sort() {
                Arrays.sort(arr);
            }
        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }


}


//TIME