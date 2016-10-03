/* A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

import java.util.stream.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class problem_9 {
  public static void main(String args[]) {
    int requiredSum = 1000;
    int productOfTriplet = 0;
    for(int r = 0; r< requiredSum; r+=2) {
      int temp = tripletProduct(findTriplet(findFactorPairs(r), r, requiredSum));
      if(temp>productOfTriplet) productOfTriplet = temp;
    }
    if(productOfTriplet != 0) {
      System.out.println("The product of the Pythagorean triplet is: " +productOfTriplet);
    } else {
      System.out.println("No triplet exists with sum of " + requiredSum + ".");
    }
  }

  //Method to find the product of the Pythagorean triplet:
  private static int tripletProduct(int[] num) {
    return IntStream.of(num).reduce(1, (x,y) -> x*y);
  }

  //Method returns all factor pairs of the 'stFactor' [Dickson's Method]:
  private static int[][] findFactorPairs (int r) {
    //Triplet are factors of the 'stFactor':
    int stFactor = (int) (Math.pow(r,2))/2;

    List<Integer> factorPair1 = new ArrayList<Integer>();
    List<Integer> factorPair2 = new ArrayList<Integer>();
    for(int i = 1; i < ((int) Math.floor(Math.sqrt(stFactor)))+1; i++) {
      if(stFactor % i == 0) { factorPair1.add(i); factorPair2.add(stFactor/i);  }
    }

    //Converts the two factor lists into a single array (r:2 x c:#FactorPairs):
    int[] row1 = factorPair1.stream().mapToInt(Integer::intValue).toArray();
    int[] row2 = factorPair2.stream().mapToInt(Integer::intValue).toArray();
    int[][] factors = {row1, row2};
    return factors;
  }

  private static int[] findTriplet(int[][] factors, int r, int sumTriplet) {
    int[] rightTriplet = new int[3];

    //Iterates over all factors to find triplet which satisfies initial condition:
    for(int i = 0; i < factors[0].length; i++) {
      //Finding the positive integers of the Dickson's Method:
      int x = r + factors[0][i];
      int y = r + factors[1][i];
      int z = r + factors[0][i] + factors[1][i];

      if(x + y + z == sumTriplet) {
        rightTriplet[0] = x;  rightTriplet[1] = y;  rightTriplet[2] = z;
      }
    }
    //Return triplet that satisfies the 'sum' condition:
    return rightTriplet;
  }
}
