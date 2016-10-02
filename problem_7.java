/* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/

public class problem_7 {
  public static void main(String args[]) {
    int primeNoIndex = 10001;
    int primeCount = 0, indexedPrime = 0, currentNo = 1;

    /*  While the prime number index is not the same as the prime
        number index, the current number is checked if it's a
        prime. Current number is incremented by one if it's not. */
    while(primeCount < primeNoIndex) {
      if(isPrime(currentNo))  primeCount++;
      if(primeCount == primeNoIndex) indexedPrime = currentNo;

      currentNo++;
    }
    System.out.println(indexedPrime);
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
