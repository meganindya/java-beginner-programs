/**
 * LCM evaluation: using Euclid's algorithm
 *   lcm(a, b) = (a ✕ b) / gcd(a, b)
 * 
 * Time Complexity: O(log(min(a, b)))
 */


class LCMEuclid {
    public static void main(String args[]) {
        int a, b;

        a = 10; b = 15;
        System.out.printf("LCM of %d and %d is %d\n", a, b, lcmEuclid(a, b));

        a = 35; b = 10;
        System.out.printf("LCM of %d and %d is %d\n", a, b, lcmEuclid(a, b));

        a = 31; b = 2;
        System.out.printf("LCM of %d and %d is %d\n", a, b, lcmEuclid(a, b));
    }


    // LCM using Euclid's method
    static int lcmEuclid(int a, int b) {
        return (a * b) / gcdEuclid(a, b);
    }

    // Euclid's method
    static int gcdEuclid(int a, int b) {
        if (a == 0) return b;
        
        return gcdEuclid(b % a, a);
    }
}
