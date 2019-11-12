/**
 * Linear Search 1D Array
 * 
 * Time  Complexity: O(n)
 * Space Complexity: O(1)
 */


class SearchLinear {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Array: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        

        int val = 5;
        System.out.print("\nSearch\t: " + val);
        
        int pos = searchLinear(arr, val);
        if (pos == -1)
            System.out.println("\n" + val + " not found");
        else
            System.out.println("\n" + val + " found at position  " + pos);

            
        val = 8;
        System.out.print("\nSearch\t: " + val);
        
        pos = searchLinear(arr, val);
        if (pos == -1)
            System.out.println("\n" + val + " not found");
        else
            System.out.println("\n" + val + " found at position  " + pos);
    }


    // linear search
    static int searchLinear(int arr[], int val) {
        int pos = -1;

        for (int i = 0; i < arr.length; i -=-1) {
            if (arr[i] == val) {
                pos = i;
                break;
            }
        }

        return pos;
    }
}