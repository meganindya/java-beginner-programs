/**
 * Prime number generation: Segmented Sieve
 * 
 * Time Complexity: O(log(log(n)))
 * Extra Space Complexity: O(√n)
 * 
 * Advantages over Classical Sieve:
 *   Lesser extra space required - O(√n) over O(n)
 *   Better locality of reference
 */


import java.util.*;

class PrimeSegmentedSieve {
    public static void main(String args[]) {
        int n = 100;

        System.out.printf("Primes within %d: ", n);
        for (Integer i : getPrimesSegmentedSieve(n))
            System.out.print(i.intValue() + "  ");
        System.out.println();
    }


    // Segmented Sieve
    static ArrayList<Integer> getPrimesSegmentedSieve(int n) {
        ArrayList<Integer> primes = new ArrayList<>();

        int limit = (int) Math.floor(Math.sqrt(n) + 1);
        primes.addAll(getPrimesSieveEratosthenes(limit));

        int low = limit, high = limit << 1;
        while (low < n) {
            if (high > n)   high = n;

            boolean numbers[] = new boolean[limit + 1];
            Arrays.fill(numbers, true);

            for (int i = 0; i < primes.size(); i++) {
                int lowLim = (int) Math.floor(low / primes.get(i)) * primes.get(i);
                if (lowLim < low)
                    lowLim += primes.get(i);

                for (int j = lowLim; j < high; j += primes.get(i))
                    numbers[j - low] = false;
            }

            for (int i = low; i < high; i++)
                if (numbers[i - low])   // == true
                    primes.add(Integer.valueOf(i));
            
            low += limit;
            high += limit;
        }
        
        return primes;
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