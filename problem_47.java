/* The first two consecutive numbers to have two distinct prime factors are:

                              14 = 2 × 7
                              15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

                            644 = 2² × 7 × 23
                            645 = 3 × 5 × 43
                            646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors.
What is the first of these numbers?
*/

import java.util.Set;
import java.util.HashSet;

public class problem_47 {
  public static void main(String args[]) {
    int noOfPrimeFactors = 4, number = 1;
    boolean nosFound = false;

    while(!nosFound) {
      if(getNoOfPrimeFactors(number) == noOfPrimeFactors
          && getNoOfPrimeFactors(number+1) == noOfPrimeFactors
          && getNoOfPrimeFactors(number+2) == noOfPrimeFactors
          && getNoOfPrimeFactors(number+3) == noOfPrimeFactors) {
            nosFound = true;
      }
      else {
        number++;
      }
    }

    System.out.println("The first four consecutive integers to have four distinct"
                    +" prime factors is: " +number);
  }

  private static int getNoOfPrimeFactors(int num) {
    Set<Integer> divisors = new HashSet<Integer>();
    int number = num, i = 2;
    while(number > 1) {
      if(number % i == 0 && isPrime(i))  {
        number /= i;
        divisors.add(i);
      }
      else i++;
    }
    return divisors.size();
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