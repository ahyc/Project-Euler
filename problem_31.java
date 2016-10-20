/* In England the currency is made up of pound, £, and pence, p, and there are
eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?
*/

public class problem_31 {
  public static void main(String args[]) {
    int total = 200, possibilities = 0;

    for (int twoPound = total; twoPound >= 0; twoPound -= 200) {
      for (int onePound = twoPound; onePound >= 0; onePound -= 100) {
          for (int fiftyP = onePound; fiftyP >= 0; fiftyP -= 50) {
              for (int twentyP = fiftyP; twentyP >= 0; twentyP -= 20) {
                  for (int tenP = twentyP; tenP >= 0; tenP -= 10) {
                      for (int fiveP = tenP; fiveP >= 0; fiveP -= 5) {
                          for (int twoP = fiveP; twoP >= 0; twoP -= 2) {
                              possibilities++;
                          }
                      }
                  }
              }
          }
      }
    }

    System.out.println("There are " +possibilities
                      +" different ways a £2 can be made using any number of coins");

  }
}