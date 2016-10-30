/* The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases
by 3330, is unusual in two ways:
    (i) each of the three terms are prime, and,
    (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class problem_49 {
  public static void main(String args[]) {
    int upperLimit = 10000;
    StringBuilder twelveDigitNo = new StringBuilder();
    String result = "";

    List<Integer> primeNos = new ArrayList<Integer>();
    for(int i = 1489; i < upperLimit; i++) {
      if(isPrime(i))   primeNos.add(i);
    }

    boolean found = false;
    for(int i = 0; i < primeNos.size(); i++) {
      if(found) break;

      for(int j = (i+1); j < primeNos.size(); j++) {
        int difference = primeNos.get(j) - primeNos.get(i);
        int nextPrime = primeNos.get(j) + difference;

        if(primeNos.contains(nextPrime)) {
          String temp = twelveDigitNo.append(primeNos.get(i))
                                     .append(primeNos.get(j))
                                     .append(nextPrime).toString();
          if(containsSameNDigits(temp, 4)) {
            result = temp;
            found = true; break;
          }
          else
            twelveDigitNo.setLength(0);
        }
      }
    }

    System.out.println("The 12-digit number formed by concatenating the three terms"
                          +" in such sequence is: " +result);
  }

  private static boolean containsSameNDigits(String num, int digits) {
    String[] primes = new String[3];
    for(int i = 0; i < primes.length; i++) {
      primes[i] = num.substring(i+(i*(digits-1)), (i+1)*digits);
    }

    char[] prime1 = primes[0].toCharArray();  Arrays.sort(prime1);
    char[] prime2 = primes[1].toCharArray();  Arrays.sort(prime2);
    char[] prime3 = primes[2].toCharArray();  Arrays.sort(prime3);

    return (Arrays.equals(prime1, prime2) && Arrays.equals(prime2, prime3))?
      true: false;
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