/* A permutation is an ordered arrangement of objects. For example, 3124 is one
possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are
listed numerically or alphabetically, we call it lexicographic order.

The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits
0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*/

import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.StringBuilder;

/*
    variables: number of digits, the nth permutation

    Description:
      Fixes one of the (n) digits and finds the number of permutations with the
      remaining digits.

      For permutations of (n-x) digits, where 'x' is the number of fixed digits,
      the nth permutation number is divided by multiples of this number. If the
      nth permutation number is surpassed, the multiple number is reduced by one
      and the 'x'th digit can be extrapolated. This process is repeated for all
      digits, until the nth permutation is found.
*/

public class problem_24 {
  public static void main(String args[]) {
    int numOfDigits = 10, nthNum = 1000000;
    StringBuilder nthPermutation = new StringBuilder();

    List<Integer> digits = new ArrayList<Integer>
                                (Arrays.asList(0,1,2,3,4,5,6,7,8,9));

    for(int fixedNo = 1; fixedNo < numOfDigits+1; fixedNo++) {
        int[] element =  getNthPermutation(nthNum, digits);

        //Replaces the permutations remaining after finding the next digit:
        nthNum = element[1];
        nthPermutation.append(digits.get(element[0]));
        digits.remove(Integer.valueOf(digits.get(element[0])));
    }

    System.out.println("The millionth lexicographic permutation of the digits is: "
                        +nthPermutation.toString());
  }

  //Method calculates the total number of permutations (n!) for n digits
  private static int calculatePermutations(int n) {
    if(n > 0)  return IntStream.rangeClosed(1, n)
                          .reduce(1, (x,y) -> x * y);
    else  return 1;
  }


  private static int[] getNthPermutation(int limit, List<Integer> digits) {
    int[] nthElement = new int[2];
    int noOfDigits = digits.size();

    //'nthElement' array contains the multiple of given permutation within the limit
    //and the remaining permutations after subtracting the multiple product:
    nthElement[0] = limit/calculatePermutations(noOfDigits-1);
    nthElement[1] = limit - (nthElement[0] * calculatePermutations(noOfDigits-1));

    //If the limit is surpassed, the divisor number is reduced by one:
    if(nthElement[1] <= 0) {
      nthElement[0] = (nthElement[0]==0)? 0: nthElement[0]-1;
      nthElement[1] += calculatePermutations(digits.size()-1);
    }

    return nthElement;
  }
}