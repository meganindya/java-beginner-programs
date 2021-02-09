import java.util.*;

class BinaryHexadecimal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary number: ");
        String s = sc.nextLine();
        int l = s.length();
        
        String A[] = {"0000", "0001", "0010", "0011",
                      "0100", "0101", "0110", "0111",
                      "1000", "1001", "1010", "1011",
                      "1100", "1101", "1110", "1111"};
        
        if ((l % 4) != 0)
            for (int i = 1; i <= (4 - (l % 4)); i++)
                s = "0" + s;
        
        for (int i = 0; i < s.length(); i += 4) {
            String t = s.substring(i, i + 4);
            for (int j = 0; j <= 15; j++) {
                if (t.equals(A[j])) {
                    if (j < 10) System.out.print(j);
                    else        System.out.print((char)(j + 55));
                }
            }
        }

        sc.close();
    }
}
