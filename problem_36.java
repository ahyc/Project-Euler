/* The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in
base 10 and base 2.
*/

import java.lang.StringBuilder;

public class problem_36 {
  public static void main(String args[]) {
    int upperLimit = 1000000, sum = 0;

    //Increment 'i' by 2 to loop over odd numbers (even numbers lead with '0'):
    for(int i = 1; i < upperLimit; i += 2) {
      if(isBaseXPalindromic(i,10) && isBaseXPalindromic(i,2))
        sum += i;
    }

    System.out.println("The sum of all numbers, less than " +upperLimit+
                        ", which are palindromic in base 10 and base 2 is: " +sum);
  }

  private static boolean isBaseXPalindromic(int num, int x) {
    return Integer.toString(num, x)
              .equals(new StringBuilder(Integer.toString(num,x)).reverse().toString());
  }
}