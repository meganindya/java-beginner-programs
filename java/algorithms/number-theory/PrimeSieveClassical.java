/**
 * Prime number generation: Classical Sieve of Eratosthenes
 * 
 * Time Complexity: O(log(log(n)))
 * Extra Space Complexity: O(n)
 */


import java.util.*;

class PrimeSieveClassical {
    public static void main(String args[]) {
        int n = 100;

        System.out.printf("Primes within %d: ", n);
        for (Integer i : getPrimesSieveEratosthenes(n))
            System.out.print(i.intValue() + "  ");
        System.out.println();
    }

    // Classical Sieve of Eratosthenes
    static ArrayList<Integer> getPrimesSieveEratosthenes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();

        boolean numbers[] = new boolean[n + 1];
        Arrays.fill(numbers, true);

        for (int i = 2; i * i <= n; i++)
            if (numbers[i])         // == true
                for (int j = i * i; j <= n; j += i)
                    numbers[j] = false;

        for (int i = 2; i <= n; i++)
            if (numbers[i])         // == true
                primes.add(Integer.valueOf(i));

        return primes;
    }
}
