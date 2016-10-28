/* The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
*/

import java.math.BigInteger;

public class problem_48 {
  public static void main(String args[]) {
    int limit = 1000;
    BigInteger total = BigInteger.ZERO;

    for(int i = 1; i < limit+1; i++) {
      BigInteger number = BigInteger.valueOf(i);
      total = total.add(number.pow(i));
    }

    String sum = total.toString();
    String tenDigits = sum.substring(sum.length()-10);

    System.out.println("The last ten digits of the series, 1^1 + 2^2 + 3^3 +"
                          + " ... + 1000^1000 is: " +tenDigits);
  }
}