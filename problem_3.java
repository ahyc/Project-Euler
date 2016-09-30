/*

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

import java.util.stream.IntStream;
import java.lang.Math;

public class problem_3 {
  public static void main(String args[]) {
    long number = 600851475143L;

    IntStream.rangeClosed(1,(int) Math.floor(Math.sqrt(number)))
      .filter((i) -> number%i == 0 && isPrime(i))
      .boxed()
      .reduce(Integer::max)
      .ifPresent(System.out::println);
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
