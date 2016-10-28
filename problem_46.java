/* It was proposed by Christian Goldbach that every odd composite number can be
written as the sum of a prime and twice a square.

                               9 =  7 + 2×1^2
                              15 =  7 + 2×2^2
                              21 =  3 + 2×3^2
                              25 =  7 + 2×3^2
                              27 = 19 + 2×2^2
                              33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime
and twice a square?
*/

public class problem_46 {
  public static void main(String args[]) {
    int compositeNo = 9, falseComposite = 0;
    boolean conjecture = true;

    //Create an array containing two times of each square:
    int[] twiceASquare = new int[100];
    for(int i = 0; i < twiceASquare.length; i++) {
      twiceASquare[i] = (i+1)*(i+1)*2;
    }

    while(conjecture) {
      //Increment the number and increment again until the number is non-prime:
      compositeNo += 2;
      while(isPrime(compositeNo)) { compositeNo += 2; }

      int index = 0;
      conjecture = false;
      while(compositeNo > twiceASquare[index]) {
        //If the difference is prime, the current number satisfies the conjecture:
        if(isPrime(compositeNo - twiceASquare[index])) {
          conjecture = true;
          break;
        }
        index++;
      }
    }

    System.out.println("The smallest odd composite that cannot be written as the" +
                        " sum of a prime and twice a square is: " +compositeNo);
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return false;
    return true;
  }
}