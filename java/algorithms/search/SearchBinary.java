/**
 * Binary Search 1D Array (while-loop method)
 * 
 * Time  Complexity: O(log n)
 * Space Complexity: O(1)
 */


class SearchBinary {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.print("Array: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        

        int val = 6;
        System.out.print("\nSearch\t: " + val);
        
        int pos = searchBinary(arr, val);
        if (pos == -1)
            System.out.println("\n" + val + " not found");
        else
            System.out.println("\n" + val + " found at position  " + pos);


        val = 8;
        System.out.print("\nSearch\t: " + val);
        
        pos = searchBinary(arr, val);
        if (pos == -1)
            System.out.println("\n" + val + " not found");
        else
            System.out.println("\n" + val + " found at position  " + pos);
    }


    // binary search
    static int searchBinary(int arr[], int val) {
        int pos = -1;

        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == val) {
                pos = mid;
                break;
            }

            else if (arr[mid] < val)
                low = mid + 1;

            else if (arr[mid] > val)
                high = mid - 1;
        }


        return pos;
    }
}