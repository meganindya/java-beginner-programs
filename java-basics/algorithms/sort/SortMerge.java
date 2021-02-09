/**
 * Merge Sort
 * 
 * Time  Complexity: O(n log n)
 * Space Complexity: O(n)
 */


class SortMerge {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : mergeSort(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // merge sort function
    static int[] mergeSort(int arr[]) {
        mergeSort(arr, 0, arr.length - 1);

        return arr;
    }

    // merge sort overloaded function
    static void mergeSort(int arr[], int low, int high) {
        if (low >= high)    return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        mergeUtil(arr, low, mid, high);
    }

    // merge utility function
    static void mergeUtil(int arr[], int low, int mid, int high) {
        int len1 = mid - low + 1;
        int len2 = high - mid;

        int ar1[] = new int[len1];
        int ar2[] = new int[len2];

        for (int i = 0; i < len1; i++)
            ar1[i] = arr[low + i];
        
        for (int i = 0; i < len2; i++)
            ar2[i] = arr[mid + i + 1];
        
        
        int k = low, i = 0, j = 0;
                
        while (i < len1 && j < len2) {
            if (ar1[i] < ar2[j])
                arr[k++] = ar1[i++];
            else
                arr[k++] = ar2[j++];
        }
        
        
        while (i < len1)
            arr[k++] = ar1[i++];
        
        while (j < len2)
            arr[k++] = ar2[j++];
    }
}