/* The fraction 49/98 is a curious fraction, as an inexperienced mathematician
in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is
correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than
one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find
the value of the denominator.
*/

import java.math.BigInteger;

public class problem_33 {
  public static void main(String args[]) {
    int lowestValue = 10, highestValue = 99;
    int productNum = 1, productDenom = 1;

    for(int denominator = highestValue; denominator >= lowestValue; denominator--) {
      for(int numerator = lowestValue; numerator < denominator; numerator++) {
        int commonDigit = findCommonDigit(numerator, denominator);

        if(isNonTrivialFractions(numerator, denominator, commonDigit) &&
                commonDigit != -1) {
          productNum *= Integer.parseInt(removeCommonDigit(numerator, commonDigit));
          productDenom *= Integer.parseInt(removeCommonDigit(denominator, commonDigit));
        }
      }
    }

    //The denominator is converted to its lowest common term:
    int lctDenom = productDenom / (BigInteger.valueOf(productDenom)
                                    .gcd(BigInteger.valueOf(productNum))
                                    .intValue());

    System.out.println("The value of the denominator in its lowest common term is: "
                          +lctDenom);
  }

  //Method to find the non-zero common digit of the numerator and denominator:
  private static int findCommonDigit(int top, int bottom) {
    String num = String.valueOf(top);
    String denom = String.valueOf(bottom);

    int commonDigit = -1;
    for(int i = 0; i < num.length(); i++) {
      if(denom.contains(String.valueOf(num.charAt(i)))) {
        int digit = Character.getNumericValue(num.charAt(i));

        if(digit != 0)  commonDigit = digit;
      }
    }
    return commonDigit;
  }

  //Method to check whether the fraction if the fractions are equal once the
  //common digit is removed:
  private static boolean isNonTrivialFractions(int top, int bottom, int digit) {
    String num = removeCommonDigit(top, digit);
    String denom = removeCommonDigit(bottom, digit);

    double fraction1 = (double) top/bottom;
    double fraction2 = Double.parseDouble(num)/Double.parseDouble(denom);

    return (fraction1 == fraction2)? true: false;
  }


  //Method to remove the common digit from the number:
  private static String removeCommonDigit(int num, int digit) {
    return String.valueOf(num).replaceFirst(String.valueOf(digit), "");
  }
}