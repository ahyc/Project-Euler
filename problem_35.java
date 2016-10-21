/* The number, 197, is called a circular prime because all rotations of the
digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73,
79, and 97.

How many circular primes are there below one million?
*/

import java.lang.StringBuilder;

public class problem_35 {
  public static void main(String args[]) {
    int upperLimit = 1000000, circularPrimes = 0;

    for(int num = 1; num < upperLimit; num++) {
      if(num < 10 && isPrime(num))  circularPrimes++;
        else if(!containsEvenNo(num) && isPrime(num)) {

          if(isCircularPrime(num))
              circularPrimes++;

        }
    }
    
    System.out.println("The number of circular primes are there below "
                      +upperLimit+ " is: " +circularPrimes);
  }

  private static boolean isCircularPrime(int number) {
    String num = String.valueOf(number);
    int noOfRotations = num.length()-1;
    boolean notCircularPrime = false;

    for(int i = 0; i < noOfRotations; i++) {
      int firstNo = Character.getNumericValue(num.charAt(0));
      num = new StringBuilder(num.substring(1))
                  .append(String.valueOf(firstNo))
                  .toString();

      if(!isPrime(Integer.parseInt(num))) {
        notCircularPrime = true;
        break;
      }
    }

    return !notCircularPrime;
  }

  private static boolean containsEvenNo(int num) {
    boolean isEven = false;
    while(num > 0) {
      if((num%10) % 2 ==0) {
        isEven = true;  break;
      }
      num /= 10;
    }
    return isEven;
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