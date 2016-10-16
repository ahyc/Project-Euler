/* A unit fraction contains 1 in the numerator. The decimal representation of
the unit fractions with denominators 2 to 10 are given:

    1/2	  = 	0.5
    1/3	  = 	0.(3)
    1/4	  = 	0.25
    1/5	  = 	0.2
    1/6	  = 	0.1(6)
    1/7	  = 	0.(142857)
    1/8	  = 	0.125
    1/9	  = 	0.(1)
    1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in
its decimal fraction part.
*/

import java.util.ArrayList;
import java.util.List;

// Variable: Upper limit of the value, d

public class problem_26 {
  public static void main(String args[]) {
    int upperLimit = 1000;
    int maxPattern = 0, longestValue = 0;

    for(int denom = upperLimit-1; denom > 0; denom--) {
      //Break 'for' loop if the number, d, is less than the current longest
      //recurring cycle:
      if(maxPattern > denom)  break;

      int count = 1, remainder = 1%denom;
      List<Integer> remainders = new ArrayList<Integer>();

      while(remainder != 0) {
        //If the remainder is repeated, the remainder cycle is repeated and the
        //'while' loop is broken:
        if(!remainders.contains(remainder)) remainders.add(remainder);
          else  break;
        remainder = (remainder * 10) % denom;
        count++;
      }

      if(maxPattern < count-1) {
        maxPattern = count-1;
        longestValue = denom;
      }
    }

    System.out.println("The value of d < " +upperLimit+
                        " for which 1/d contains the longest recurring cycle is: "
                              +longestValue);
  }

}