/* If p is the perimeter of a right angle triangle with integral length sides,
{a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
*/

//Pythagoras theorem: a^2 + b^2 = c^2
//Triangle Perimeter: a + b + c = p     => c = p - a - b

//Therefore:  a^2 + b^2 = (p-a-b)^2 =  p^2 - 2pa – 2pb + 2ab + a^2 + b^2
//                    => b = (p^2 - 2pa) / 2(p - a)
//For varying values of 'a' and 'p', if 'b' is a whole number, a solution is found.

public class problem_39 {
  public static void main(String args[]) {
    int upperBound = 1000, bestPValue = 0, currentMaxSol = 0;

    for(int perimeter = 1; perimeter <= upperBound; perimeter++) {
      int solutions = 0;

      //The sides of the triangle must be less than p/2 (due to Pythagoras theorem)
      for(int a = 1; a < perimeter/2; a++) {
        if(((perimeter*perimeter)-(2*perimeter*a)) % (2*(perimeter-a)) == 0)
          solutions++;

        if(solutions > currentMaxSol) {
          bestPValue = perimeter;
          currentMaxSol = solutions;
        }
      }
    }

    System.out.println("The number of solutions maximised for p ≤ " +upperBound+
                          " is: " +bestPValue);
  }
}