/* 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

import java.util.stream.IntStream;
import java.lang.Math;

public class problem_5 {
  public static void main(String args[]) {
    /*Since the numbers 1 through to 10 inclusive are factors of numbers between 11 to 20,
      those numbers are cancelled out. The rest of the numbers will be used to find the lowest
      common multiple. */

    //Array of prime numbers between 0 and 10 (used to calculate Lowest Common Multiple):
    int[] lowestPrimes = IntStream.rangeClosed(0,10)
      .filter(x -> isPrime(x))
      .toArray();

    //The product of all the primes between 11 and 20:
    int productOfPrimes11to20 = IntStream.rangeClosed(11,20)
      .filter(x -> isPrime(x))
      .reduce(1, (x,y) -> x*y);

    //List of non-prime factors between 11 and 20:
    int[] nonPrimesBetween11to20 = IntStream.rangeClosed(11,20)
      .filter(x -> isPrime(x) == false)
      .toArray();

    //
    int[] frequency = new int[lowestPrimes.length];

    for(int i = 0; i<lowestPrimes.length; i++) {
      while(isDivisible(nonPrimesBetween11to20, lowestPrimes[i])) {
        nonPrimesBetween11to20 = divideArray(nonPrimesBetween11to20, lowestPrimes[i]);
        frequency[i]++;
      }
    }

    int lowestCommonMultiple = productOfPrimes11to20 * productOfNonPrimes(lowestPrimes, frequency);

    System.out.println(lowestCommonMultiple);
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return false;
    return true;
  }

  private static boolean isDivisible(int[] array, int divisor) {
    return IntStream.of(array).anyMatch((x) -> x%divisor == 0);
  }

  private static int[] divideArray(int[] array, int divisor) {
    for(int i = 0; i <array.length; i++) {
      if(array[i] % divisor == 0) array[i] /= divisor;
    }
    return array;
  }

  private static int productOfNonPrimes(int[] lowestPrimes, int[] frequency) {
    int product = 1;
    for(int i = 0; i<lowestPrimes.length; i++) {
      product *= Math.pow(lowestPrimes[i], frequency[i]);
    }
    return product;
  }
}
