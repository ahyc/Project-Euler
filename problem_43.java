/* The number, 1406357289, is a 0 to 9 pandigital number because it is made up
of each of the digits 0 to 9 in some order, but it also has a rather interesting
sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the
following:

    d_2 d_3 d_4 = 406 is divisible by 2
    d_3 d_4 d_5 = 063 is divisible by 3
    d_4 d_5 d_6 = 635 is divisible by 5
    d_5 d_6 d_7 = 357 is divisible by 7
    d_6 d_7 d_8 = 572 is divisible by 11
    d_7 d_8 d_9 = 728 is divisible by 13
    d_8 d_9 d_10 = 289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.
*/

//d_4 must be an even number
//d_6 must be '5', since d_6 -> d_8 must be divisible by '11' (cannot be '0')

import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.lang.StringBuilder;

public class problem_43 {
  public static void main(String args[]) {
    List<String> numbers = new ArrayList<String>();

    for(int d6to8 = 500; d6to8 < 600; d6to8++) {
      if(d6to8 % 11 == 0 && checkPandigital(String.valueOf(d6to8)))
        numbers.add(String.valueOf(d6to8));
    }
    getNextDigit(numbers, 13);
    getNextDigit(numbers, 17);
    getPrevDigit(numbers, 7);

    List<String> digits = new ArrayList<String>();
    for(String number:numbers) {
      for(int i = 0; i < 10; i += 2) {
        String temp = new StringBuilder(String.valueOf(i))
                          .append(number)
                          .toString();
        if(checkPandigital(temp))  digits.add(temp);
      }
    }
    getPrevDigit(digits, 3);
    List<String> pandigitalNos = getPandigitalNos(digits);

    long sum = pandigitalNos.stream().mapToLong(Long::parseLong).sum();

    System.out.println("The sum of all 0 to 9 pandigital numbers with the property is: "
                          +sum);
  }

  private static List<String> getPandigitalNos(List<String> num) {
    List<String> numbers = new ArrayList<String>();
    for(String x: num) {
      for(int i = 10; i < 98; i ++) {
        String temp = new StringBuilder(String.valueOf(i))
                          .append(x)
                          .toString();
        if(checkPandigital(temp)) numbers.add(temp);
      }
    }

    return numbers;
  }

  private static void getPrevDigit(List<String> numbers, int divisor) {
    for(String number:numbers) {
      for(int i = 0; i < 10; i++) {
        int last3Nos = Integer.parseInt(new StringBuilder(String.valueOf(i))
                                            .append(number.substring(0,2))
                                            .toString());

        if(last3Nos % divisor == 0 && checkPandigital(String.valueOf(last3Nos))
              && String.valueOf(last3Nos).length() >= 2) {
          String newNos = new StringBuilder(String.valueOf(i))
                            .append(number)
                            .toString();
          numbers.set(numbers.indexOf(number), newNos);
          break;
        }
      }
    }

    filterList(numbers);
  }

  private static void getNextDigit(List<String> numbers, int divisor) {
    for(String number:numbers) {
      for(int i = 0; i < 10; i++) {
        int next3Nos = Integer.parseInt(new StringBuilder(number.substring(number.length()-2))
                                            .append(String.valueOf(i))
                                            .toString());

        if(next3Nos % divisor == 0 && checkPandigital(String.valueOf(next3Nos))) {
          String newNos = new StringBuilder(number)
                            .append(String.valueOf(i))
                            .toString();
          numbers.set(numbers.indexOf(number), newNos);
          break;
        }
      }
    }

    filterList(numbers);
  }

  private static void filterList(List<String> numbers) {
    int longestLength = numbers.stream()
                                .max(Comparator.comparing(String::length))
                                .get().length();
    for(Iterator<String> ob = numbers.iterator(); ob.hasNext();) {
      String number = ob.next();
      if(!checkPandigital(number) || number.length() < longestLength)
        ob.remove();
    }
  }

  private static boolean checkPandigital(String number) {
    if(number.length() > 10)  return false;

    int[] array = new int[10];
    for(int i = 0; i < number.length(); i++) {
      int digit = Character.getNumericValue(number.charAt(i));
      if(digit < array.length && array[digit] == 0)
        array[digit]++;
      else return false;
    }

    return (IntStream.of(array).sum() == number.length())? true: false;
  }
}