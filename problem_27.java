/* Euler discovered the remarkable quadratic formula:

                        (n^2) + n + 41

It turns out that the formula will produce 40 primes for the consecutive integer
values 0 ≤ n ≤ 39.
However, when [n = 40, 40^2 + 40 + 41 = 40*(40+1) + 41] is divisible by 41, and
certainly when [n = 41, 41^2 + 41 + 41] is clearly divisible by 41.

The incredible formula [n^2 − 79n + 1601] was discovered, which produces 80 primes
for the consecutive values 0 ≤ n ≤ 79. The product of the coefficients, −79 and
1601, is −126479.

Considering quadratics of the form:

    (n^2) + an + b, where |a| < 1000 and |b| ≤ 1000

    where |n| is the modulus/absolute value of n
    e.g. |11| = 11 and |−4| = 4

Find the product of the coefficients, a and b, for the quadratic expression that
produces the maximum number of primes for consecutive values of n, starting with
n = 0.
*/

public class problem_27 {
  public static void main (String args[]) {
    int optimalA = 0, optimalB = 0, maxPrimes = 0;
    int upperLimit = 1000;
    for(int a = -upperLimit+1; a < 1000; a++) {
      for(int b = -upperLimit+1; b < 1000; b++) {
        int n = 0;
        while(isPrime((n*n) + (a*n) + b)) {
          n++;
        }
        if(n > maxPrimes) {
          optimalA = a; optimalB = b;
          maxPrimes = n;
        }
      }
    }

    System.out.println("The product of the coefficients, a and b, that produces "
                      +" the maximum number of primes for consecutive values of n is: "
                        +(optimalA * optimalB));
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return false;
    return true;
  }
}