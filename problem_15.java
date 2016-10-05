/* Starting in the top left corner of a 2×2 grid, and only being able to move to
the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
*/

import java.util.stream.LongStream;

public class problem_15 {
  public static void main(String args[]) {
    //The number of lattice paths can be calculated using the binomial
    //coefficient {(n+k); n}, where {n;k} are grid numbers:
    int[] gridSize = {20, 20};
    System.out.println("The number of routes through a "
        +gridSize[0]+ " " +gridSize[1]+ " grid is: "
          + binomialCoef(gridSize[0]+gridSize[1],gridSize[0]));
  }

  private static long binomialCoef (int n, int k) {
    //Calculating the binomial coefficient using the multiplicative formula:
    return LongStream.rangeClosed(1,k)
              .reduce(1, (x,y) -> x * (n + 1 - y)/y);
  }
}