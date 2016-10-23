/* The number 3797 has an interesting property. Being prime itself, it is
possible to continuously remove digits from left to right, and remain prime at
each stage: 3797, 797, 97, and 7.

Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to
right and right to left.
*/

public class problem_37 {
  public static void main(String args[]) {
    int count = 1, sum = 0, number = 1;

    while(count < 12) {
      if(isTruncatablePrime(number) && number > 10) {
        count++;
        sum += number;
      }
      number += 2;
    }

    System.out.println("The sum of the eleven primes that are both truncatable"
                          +" from left to right and right to left is: " +sum);
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return false;
    return true;
  }

  private static boolean isTruncatablePrime(int num) {
    if(!isPrime(num)) return false;

    String LRnumber = String.valueOf(num);
    String RLnumber = String.valueOf(num);

    boolean prime = true;
    //It is redundant to check whether both strings are greater than one.
    while(prime == true && LRnumber.length() > 1) {
      LRnumber = LRnumber.substring(1);
      RLnumber = RLnumber.substring(0, RLnumber.length()-1);

      if(!isPrime(Integer.parseInt(LRnumber)) || !isPrime(Integer.parseInt(RLnumber)))
        prime = false;
    }
    return prime;
  }
}