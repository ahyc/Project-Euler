/* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

import java.util.stream.LongStream;

public class problem_10 {
  public static void main(String args[]) {
    int upperBound = 2000000;

    System.out.println("The sum of all primes below " +upperBound+
      " is: "
          +LongStream.rangeClosed(0, upperBound)
                  .filter(x -> isPrime(x))
                  .sum());
  }

  private static boolean isPrime(long num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return false;
    return true;
  }
}
