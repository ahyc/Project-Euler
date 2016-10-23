/* Take the number 192 and multiply it by each of 1, 2, and 3:

    192 × 1 = 192
    192 × 2 = 384
    192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will
call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and
5, giving the pandigital, 918273645, which is the concatenated product of 9 and
(1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the
concatenated product of an integer with (1,2, ... , n) where n > 1?
*/

import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;

public class problem_38 {
  public static void main(String args[]) {
    int number = 0;

    //Upped bound is '94**' because doubling it gives a five digit number, which
    //satisfies the 9-digit number requirement, and the resulting double doesn't
    //contain another '9', i.e. the double isn't '19***'.
    for(int i = 9487; i > 9234; i--) {
      String nineDigitNo = new StringBuilder(String.valueOf(i))
                                .append(String.valueOf(i*2))
                                .toString();
                                
      if(checkPandigital(nineDigitNo)) {
        number = Integer.parseInt(nineDigitNo);
        break;
      }
    }

    System.out.println("The largest 1 to 9 pandigital 9-digit number that can be"
                        +" formed as the concatenated product of (1,2, ... , n) is: "
                          +number);
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