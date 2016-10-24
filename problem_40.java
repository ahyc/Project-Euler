/* An irrational decimal fraction is created by concatenating the positive
integers:

                  0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If d_n represents the nth digit of the fractional part, find the value of the
following expression.

      d_1 × d_10 × d_100 × d_1000 × d_10000 × d_100000 × d_1000000
*/

public class problem_40 {
  public static void main(String args[]) {
    int upperBound = 1000000, product = 1, n = 1, num = 1;
    int digitsCount = calculateDigitsBefore(num);

    while(n <= upperBound) {
      //Get the range of digits between the numbers 'num' and '10*num':
      //(e.g. numbers between 10-99, inclusive, represents digits 10-189)
      int lowestDigit = digitsCount+1;
      int highestDigit = digitsCount + calculateDigitsBefore(num*10);

      //If the nth digit is within the range, the number containing the nth digit
      //is calculated:
      if(n>= lowestDigit && n <highestDigit) {
        int numFromN = (n - digitsCount+1)/String.valueOf(digitsCount+1).length();
        int remainder = (n - digitsCount)%String.valueOf(digitsCount+1).length();

        int number = num + numFromN;

        if(remainder > 0)
          product *= Character.getNumericValue(String.valueOf(number)
                                                  .charAt(remainder-1));

        n *= 10;
      }
      //Else the range is increased by a factor of 10:
      else {
        num *= 10;
        digitsCount += calculateDigitsBefore(num);
      }
    }

    System.out.println("The value of the expression is: " +product);
  }

  //Method to get the number of digits before 'num', where 'num' is a power of 10:
  private static int calculateDigitsBefore(int num) {
    if(num == 1)  return 0;

    int length = String.valueOf(num).length();
    int digitsBefore = (9 * (int) Math.pow(10, length-2)) * (length-1);

    return digitsBefore;
  }
}