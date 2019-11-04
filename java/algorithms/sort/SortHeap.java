/**
 * Heap Sort using Priority Queue
 * 
 * Time  Complexity: O(log n)
 * Space Complexity: O(n)
 */


import java.util.*;

class SortHeap {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : heapSort(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // heap sort function
    static int[] heapSort(int arr[]) {
        // creates min heap
        Queue<Integer> heap = new PriorityQueue<>();

        // for descensing order, create max heap
        //Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i : arr)
            heap.add(Integer.valueOf(i));

        int k = 0;
        while (!heap.isEmpty())
            arr[k++] = heap.poll();


        return arr;
    }
}