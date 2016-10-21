/* 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their
digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/

public class problem_34 {
  public static void main(String args[]) {
    int lowerLimit = 3, sum = 0;
    int upperLimit = 5 * factorial(9) + 1;

    for(int i = lowerLimit; i < upperLimit; i++) {
      if(isCurious(i))  sum += i;
    }

    System.out.println("The sum of all numbers which are equal to the sum of the"
                        + " factorial of their digits is: " +sum);
  }

  private static boolean isCurious (int num) {
    int total = 0;
    String number = String.valueOf(num);

    for(int i = 0; i < number.length(); i++)  {
      total += factorial(Character.getNumericValue(number.charAt(i)));
    }

    return (total == num)? true: false;
  }

  private static int factorial(int num) {
    if(num <= 1)  return 1;
    return num*factorial(num-1);
  }
}
