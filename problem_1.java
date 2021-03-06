/*

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

import java.util.stream.IntStream;

public class problem_1 {
  public static void main(String args[]) {
    System.out.println("The sum of all multiples of 3 and 5 below 1000 is: "
    +IntStream.range(0,1000)
      .filter(i-> i%3 == 0 || i%5 == 0)
      .sum());
  }
}
