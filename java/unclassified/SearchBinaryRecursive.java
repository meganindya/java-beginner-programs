import java.util.*;

class SearchBinaryRecursive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        String ar[] = new String[n];

        System.out.println("\n" + "Enter array elements: ");
        for (int i = 0; i < n; i++)
            ar[i] = sc.next() + sc.nextLine();

        System.out.print("\n"+"Enter the element you want to search for: ");
        String key = sc.next() + sc.nextLine();

        int pos = searchBinRec(ar, key, 0, (ar.length - 1));
        if(pos == -1)
            System.out.println(key + " was not found!");
        else
            System.out.println(key + " was found at position " + (pos + 1));

        sc.close();
    }

    public static int searchBinRec(String ar[], String key, int start, int end) {
        int mid = start + (end - start) / 2;

        if      (start > end)
            return -1;
        
        if      (ar[mid].compareToIgnoreCase(key) == 0)
            return mid;
        else if (ar[mid].compareToIgnoreCase(key) < 0)
            return searchBinRec(ar, key, mid + 1, end);
        else
            return searchBinRec(ar, key, start, mid - 1);
    }
}

/* O U T P U T:
 * Enter size of array:
 * 5
 * Enter array elements:
 * Propositional Logic
 * Computer Structure
 * Data Representation
 * Recursion
 * String Tokenizer
 * ------------------------------
 * Enter the element you want to search for:
 * Recursion
 * Recursion was found at position=4
 */
