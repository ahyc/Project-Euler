import java.lang.Math;
import java.lang.StringBuilder;

public class problem_4 {
  public static void main (String args[]) {
    //For-Loop method:
    int largestProduct = 0;

    for(int i = 800; i<1000; i++) {
      for(int j = 800; j<1000; j++) {
        if(isPalindromic(i*j)) largestProduct = i*j;
      }
    }
    System.out.println("The largest palindrome is: " +largestProduct);
  }

  private static boolean isPalindromic(int num) {
    return Integer.toString(num)
              .equals(new StringBuilder(Integer.toString(num)).reverse().toString());
  }
}
