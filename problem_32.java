/* We shall say that an n-digit number is pandigital if it makes use of all the
digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through
5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can
be written as a 1 through 9 pandigital.
*/

import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;

public class problem_32 {
  public static void main(String args[]) {
    int sum = 0;

    Set<Integer> pandigitalProducts = new HashSet<Integer>();

    for(int multiplicand = 1; multiplicand < 99; multiplicand++) {
      for(int multiplier = 111; multiplier < 9999; multiplier++) {
        int product = multiplier * multiplicand;

        //Concatenate the numbers into a string:
        String concatenated = new StringBuilder(Integer.toString(multiplier))
                                      .append(Integer.toString(multiplicand))
                                      .append(Integer.toString(product))
                                      .toString();

        //'if' loop to check if the numbers are pandigital or repeated:
        if(checkPandigital(concatenated) && !pandigitalProducts.contains(product)) {
          sum += product;
          pandigitalProducts.add(product);
        }
      }
    }

    System.out.println("The sum of all products whose multiplicand/multiplier/product"
                          +" identity can be written as a 1 through 9 pandigital is: "
                            +sum);
  }

  private static boolean checkPandigital(String num) {
    Set<Integer> numbers = new HashSet<Integer>();
    if(num.contains("0") || num.length() > 9) return false;

    for(int i = 0; i < num.length(); i++) {
      int digit = Character.getNumericValue(num.charAt(i));
      numbers.add(digit);
    }

    return (numbers.size() == 9)? true: false;
  }
}