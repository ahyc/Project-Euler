/* Let d(n) be defined as the sum of proper divisors of n
(numbers less than n which divide evenly into n).

If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and
each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55
and 110; therefore d(220) = 284.
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class problem_21 {
  public static void main(String args[]) {
    int upperBound = 10000;
    int sumOfAmicableNo = 0;

    List<Integer> amicablePairs = new ArrayList<Integer>();

    for(int i = 1; i < upperBound; i++) {
      int b = getSumOfDivisors(i);
      if(i != b && i == getSumOfDivisors(b))  {
        amicablePairs.add(i); amicablePairs.add(b);
      }
    }

    sumOfAmicableNo = amicablePairs.stream()
                        .mapToInt(Integer::intValue)
                        .distinct()
                        .sum();

    System.out.println("The sum of all the amicable numbers under " +upperBound+
                          " is: " +sumOfAmicableNo);

  }

  private static int getSumOfDivisors(int num) {
    List<Integer> divisors = new ArrayList<Integer>();
    for(int i = 1; i < (int) Math.floor(Math.sqrt(num)); i++) {
      if(num % i == 0)  {
        divisors.add(i);
        if(num/i != num) divisors.add(num/i);
      }
    }
    return divisors.stream().mapToInt(Integer::intValue).sum();
  }
}