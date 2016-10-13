/* The Fibonacci sequence is defined by the recurrence relation:

    F_n = F_n−1 + F_n−2, where F_1 = 1 and F_2 = 1.

Hence the first 12 terms will be:

    F_1 = 1
    F_2 = 1
    F_3 = 2
    F_4 = 3
    F_5 = 5
    F_6 = 8
    F_7 = 13
    F_8 = 21
    F_9 = 34
    F_10 = 55
    F_11 = 89
    F_12 = 144

The 12th term, F_12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
*/

// Variables: number of Digits
// Assumptions: Fibonacci sequence starts with index of 3

import java.math.BigInteger;

public class problem_25 {
  public static void main(String args[]) {
    int noOfDigits = 1000;
    boolean conditionMet = false;

    BigInteger F_a = BigInteger.ONE;
    BigInteger F_b = BigInteger.ONE;
    BigInteger sum;
    BigInteger index = BigInteger.valueOf(2);

    while(conditionMet == false) {
      sum = F_a.add(F_b);
      F_a = F_b;
      F_b = sum;
      index = index.add(BigInteger.ONE);

      if(F_b.toString().length() == noOfDigits) conditionMet = true;
    }

    System.out.println("The index of the first term in the Fibonacci sequence to contain "
                        +noOfDigits+ " digits is: " +index.toString());
  }
}