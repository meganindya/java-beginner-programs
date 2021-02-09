/**
 * GCD or HCF evaluation: Euclid's algorithm
 * 
 * Time Complexity: O(log(min(a, b)))
 */


class GCDEuclid {
    public static void main(String args[]) {
        int a, b;

        a = 10; b = 15;
        System.out.printf("GCD of %d and %d is %d\n", a, b, gcdEuclid(a, b));

        a = 35; b = 10;
        System.out.printf("GCD of %d and %d is %d\n", a, b, gcdEuclid(a, b));

        a = 31; b = 2;
        System.out.printf("GCD of %d and %d is %d\n", a, b, gcdEuclid(a, b));
    }

    // Euclid's method
    static int gcdEuclid(int a, int b) {
        if (a == 0) return b;
        
        return gcdEuclid(b % a, a);
    }
}
