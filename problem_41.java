/* We shall say that an n-digit number is pandigital if it makes use of all the
digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
also prime.

What is the largest n-digit pandigital prime that exists?
*/

import java.util.stream.IntStream;

public class problem_41 {
  public static void main(String args[]) {
    int largestPandigitalPrime = 0;

    for(int num = 987654321; num > 612345; num -= 2) {
      if(checkPandigital(num)) {
        if(isPrime(num)) {
          largestPandigitalPrime = num;
          break;
        }
      }
    }

    System.out.println("The largest n-digit pandigital prime is: "
                            +largestPandigitalPrime);
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return false;
    return true;
  }

  private static boolean checkPandigital(int num) {
    String number = String.valueOf(num);
    if(number.contains("0")) return false;

    int[] array = new int[number.length()];
    for(int i = 0; i < array.length; i++) {
      int digit = Character.getNumericValue(number.charAt(i));
      if(digit <= array.length && array[digit-1] == 0)
        array[digit-1]++;
      else return false;
    }

    return (IntStream.of(array).sum() == array.length)? true: false;
  }
}