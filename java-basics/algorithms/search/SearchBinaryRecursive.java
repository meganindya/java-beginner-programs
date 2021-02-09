/**
 * Binary Search 1D Array (recursive)
 * 
 * Time  Complexity: O(log n)
 * Space Complexity: O(log n)
 */


class SearchBinaryRecursive {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.print("Array: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        

        int val = 6;
        System.out.print("\nSearch\t: " + val);
        
        int pos = searchBinaryRec(arr, val);
        if (pos == -1)
            System.out.println("\n" + val + " not found");
        else
            System.out.println("\n" + val + " found at position  " + pos);


        val = 8;
        System.out.print("\nSearch\t: " + val);
        
        pos = searchBinaryRec(arr, val);
        if (pos == -1)
            System.out.println("\n" + val + " not found");
        else
            System.out.println("\n" + val + " found at position  " + pos);
    }


    // recursive binary search recursive
    static int searchBinaryRec(int arr[], int val) {
        return searchBinaryRec(arr, val, 0, arr.length);
    }

    // overloaded utility function for recursive binary search
    static int searchBinaryRec(int arr[], int val, int low, int high) {
        int mid = low + ((high - low) >> 1);    // equivalent to low + (high - low) / 2

        if (low >= high)
            return -1;
        
        if (arr[mid] == val)
            return mid;
        
        else if (arr[mid] < val)
            return searchBinaryRec(arr, val, mid + 1, high);
        
        else
            return searchBinaryRec(arr, val, low, mid - 1);
    }
}