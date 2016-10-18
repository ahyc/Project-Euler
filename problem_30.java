/* Surprisingly there are only three numbers that can be written as the sum of
fourth powers of their digits:

    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4

As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers
of their digits.
*/

// Variable: Exponent

import java.lang.Math;

public class problem_30 {
  public static void main(String args[]) {
    int exponent = 5, total = 0;
    int upperLimit = getUpperBound(exponent);

    for(int num = 2; num < upperLimit+1; num++) {
      int sum = 0;
      String number = Integer.toString(num);

      for(int digit = 0; digit < number.length(); digit++) {
        sum += (int) Math.pow(Character.getNumericValue(number.charAt(digit)),5);
      }

      if(sum == num)  total += num;
    }

    System.out.println("The sum of all the numbers that can be written as the sum of "
                          +exponent+ "th powers of their digits is: " +total);

  }

  private static int getUpperBound(int power) {
    String highestPower = Integer.toString(5*(int) Math.pow(9, power));
    int noOfDigits = highestPower.length();

    return ((int) Math.pow(9, power)) * noOfDigits;
  }
}