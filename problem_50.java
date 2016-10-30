/* The prime 41, can be written as the sum of six consecutive primes:

                        41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime,
contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/

import java.util.List;
import java.util.ArrayList;

public class problem_50 {
  public static void main(String args[]) {
    int upperLimit = 1000000, consecutivePrimes = 0, result = 0;
    List<Integer> primeNos = new ArrayList<Integer>();
    for(int i = 0; i < upperLimit; i++) {
      if(isPrime(i))   primeNos.add(i);
    }

    //Array to hold the cumulative sum of the primes:
    //(The difference between values give the sum of its consecutive primes)
    long currentTotal = 0;
    long[] sumPrimes = new long[primeNos.size()];
    for(int i = 0; i < primeNos.size(); i++) {
      currentTotal += (long) primeNos.get(i);
      sumPrimes[i] = currentTotal;
    }

    //Nested 'for' loop to check if the difference, between elements in the array,
    //is a prime. If the difference is a prime, the consecutive prime number is
    //calculated by finding the difference between the indices.
    for(int i = 0; i < sumPrimes.length; i++) {
      for(int j = i+1; j <sumPrimes.length; j++) {
        long difference = sumPrimes[j] - sumPrimes[i];

        //Break out of the loop if the difference is a number larger than the limit:
        if(difference > (long) upperLimit)  break;

        if(primeNos.contains((int) difference) && (j-i) > consecutivePrimes) {
          consecutivePrimes = j - i;
          result = (int) difference;
        }
      }
    }

    System.out.println("The prime, below " +upperLimit+", that can be written as the"
                        +" sum of the most consecutive primes is: " +result+
                            ", with "+consecutivePrimes+ " consecutive primes");
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