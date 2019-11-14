/**
 * Quick Sort
 * 
 * Time Complexity: O(n log n) [average], O(n^2) [worst]
 */


class SortQuick {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : quickSort(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // quick sort function
    static int[] quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);

        return arr;
    }

    // quick sort overloaded utility function
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // p is partitioning index, arr[p] is now at right place
            int p = partition(arr, low, high);
  
            // recursively sort elements before and after partition
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    // takes last element as pivot, places the pivot element at its correct
    // position in sorted array, and places all smaller (smaller than pivot)
    // to left of pivot and all greater elements to right of pivot
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // index of smaller element 
        
        for (int j = low; j < high; j++) {
            // if current element is smaller than the pivot 
            if (arr[j] < pivot) {
                i++;
    
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    
        // swap arr[i + 1] and arr[high] (or pivot) 
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp; 
    
        return i + 1;
    }
}