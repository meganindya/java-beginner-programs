/**
 * Selection Sort using looping
 * 
 * Time  Complexity: O(n^2)
 * Space Complexity: O(n^2) due to stacked function calls
 */


class SortSelectionRecursive {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : selectionSortRec(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // recursive selection sort
    static int[] selectionSortRec(int arr[]) {
        return selectionSortRec(arr, 0, 0);
    }

    static int temp;

    // overloaded utility function for selection sort
    static int[] selectionSortRec(int arr[], int i, int j) {
        int length = arr.length;

        if (i < length - 1) {
            int minIndex = i;
            
            if (j < length) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
                
                selectionSortRec(arr, i, j + 1);
            }
      
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            selectionSortRec(arr, i + 1, i + 2);
        }


        return arr;
    }
}