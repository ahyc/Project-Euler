/* Starting with the number 1 and moving to the right in a clockwise direction a
5 by 5 spiral is formed as follows:

                                  21 22 23 24 25
                                  20  7  8  9 10
                                  19  6  1  2 11
                                  18  5  4  3 12
                                  17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed
in the same way?
*/

//Variable: Upper limit = the size of the spiral

public class problem_28 {
  public static void main(String args[]) {
    int sum = 1;
    int upperLimit = 1001;

    //The number of rows for an n-by-n spiral is calculated using an arithmetic
    //progression [upperLimit = 1 + ((rows - 1) * 2)]:
    int noOfRows = ((upperLimit-1)/2) + 1;

    for(int row = 2; row < noOfRows+1; row++) {
      //The formula to find the value of the bottom left corner is:
      //[(bottom left corner value) = 4n^2 - 10n + 7]
      int bottomLeft = (4*row*row) - (10*row) + 7;
      sum += bottomLeft;

      //'for' loop to add all the values in the other corners:
      for(int corner = 1; corner < 4; corner++) {
        //The difference between corner values is [(n-1) * 2], where 'n' is the row:
        sum += bottomLeft + ((row-1) * 2 * corner);
      }
    }

    System.out.println("The sum of the numbers on the diagonals in a " +upperLimit
                        +" by " +upperLimit+ " spiral is: " +sum);
  }
}