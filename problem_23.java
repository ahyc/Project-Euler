/* A perfect number is a number for which the sum of its proper divisors is
exactly equal to the number. For example, the sum of the proper divisors of
28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n
and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123
can be written as the sum of two abundant numbers. However, this upper limit
cannot be reduced any further by analysis even though it is known that the
greatest number that cannot be expressed as the sum of two abundant numbers is
less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of
two abundant numbers.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.Set;
import java.util.HashSet;

public class problem_23 {
  public static void main(String args[]) {
    int upperLimit = 28124, total = 0;
    List<Integer> abundantNo = new ArrayList<Integer>();

    for(int i = 1; i < upperLimit; i++) {
      if(isAbundantNo(i)) abundantNo.add(i);
    }

    for(int number = 1; number < upperLimit; number++) {
      boolean abundantSum = false;

      for(int list = 0; list < abundantNo.size(); list++) {
        if(number < abundantNo.get(list)) break;

        int remaining = number - abundantNo.get(list);
        if(abundantNo.contains(remaining)) {
          abundantSum = true;
          break;
        }
      }

      if(!abundantSum)  total += number;
    }

    System.out.println("The sum of all the positive integers up to " +upperLimit+
                  " which are not the sum of two abundant numbers is: " +total);
  }

  private static boolean isAbundantNo(int num) {
    Set<Integer> divisors = new HashSet<Integer>();
    for(int i = 1; i < (int) Math.ceil(Math.sqrt(num))+1; i++) {
      if(num % i == 0 && i != num)  {
        divisors.add(i);
        if(num/i != num) divisors.add(num/i);
      }
    }
    return divisors.stream().mapToInt(Integer::intValue).sum() > num ?
                    true : false;
  }
}