/* n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/

import java.math.BigInteger;
import java.util.stream.*;

public class problem_20 {
  public static void main(String args[]) {
    BigInteger upperBound = BigInteger.valueOf(100);
    BigInteger factorial = BigInteger.ONE;

    while(!upperBound.equals(BigInteger.ZERO)) {
      factorial = factorial.multiply(upperBound);
      upperBound = upperBound.subtract(BigInteger.ONE);
    }

    long sumOfDigits = Stream.of(factorial.toString().split(""))
                          .mapToLong(Long::parseLong)
                          .sum();

    System.out.println("The sum of the digits in the number 100! is: "
                          +sumOfDigits);
  }
}