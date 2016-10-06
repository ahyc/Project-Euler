/* 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/

import java.lang.Math;
import java.math.BigInteger;
import java.util.stream.Stream;

public class problem_16 {
  public static void main(String args[]) {
    BigInteger digits = BigInteger.valueOf(2);
    digits = digits.pow(1000);
    String stringDigits = digits.toString();

    System.out.println("The sum of the digits of 2^1000 is: "
                        +sumOfDigits(stringDigits));
  }

  private static int sumOfDigits(String digits) {
    //Splits a stream of string into individual characters, where
    //each character is converted into an integer and summed:
    return Stream.of(digits.split(""))
                  .mapToInt(Integer::parseInt)
                  .sum();
  }
}