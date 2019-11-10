/**
 * Insertion Sort using looping
 * 
 * Time  Complexity: O(n^2)
 * Space Complexity: O(n^2) due to stacked function callsA
 */


class SortInsertionRecursive {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : insertionSortRec(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // recursive insertion sort
    static int[] insertionSortRec(int arr[]) {
        return insertionSortRec(arr, 0, 0);
    }

    static int temp;

    // overloaded utility function for insertion sort
    static int[] insertionSortRec(int arr[], int i, int j) {
        if (i < arr.length) {
            if (j == i - 1)
                temp = arr[i];
      
            if (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                insertionSortRec(arr, i, j - 1);
            }
            else {
                arr[j + 1] = temp;
                insertionSortRec(arr, i + 1, i);
            }
        }


        return arr;
    }
}