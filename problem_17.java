/* If the numbers 1 to 5 are written out in words: one, two, three, four, five,
then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in
words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
The use of "and" when writing out numbers is in compliance with British usage.
*/

import java.util.HashMap;
import java.util.Map;
import java.lang.Math;
import java.util.stream.IntStream;

public class problem_17 {
  private static final Map<Integer, String> words;
  //Static initialiser for all numbers between 1 and upper bound:
  static {
    words = new HashMap<Integer, String>();

    //Places words between 1 and 19 onto Map:
    words.put(1, "one");  words.put(2, "two");  words.put(3, "three");
    words.put(4, "four"); words.put(5, "five"); words.put(6,"six");
    words.put(7, "seven"); words.put(8, "eight"); words.put(9,"nine");
    words.put(11, "eleven"); words.put(12,"twelve");  words.put(13, "thirteen");
    words.put(14, "fourteen"); words.put(15,"fifteen"); words.put(16, "sixteen");
    words.put(17, "seventeen"); words.put(18,"eighteen"); words.put(19, "nineteen");

    //Since numbers in their tens share words between one and nine, all numbers
    //between the tens were omitted:
    words.put(10, "ten"); words.put(20, "twenty");  words.put(30, "thirty");
    words.put(40, "forty"); words.put(50,"fifty");  words.put(60, "sixty");
    words.put(70, "seventy"); words.put(80,"eighty"); words.put(90, "ninety");

    //Numbers in their hundreds and thousands share words already in the map,
    //so numbers between the hundreds and thousands were omitted:
    words.put(100, "hundred");  words.put(1000,"thousand");
  }

  public static void main(String args[]) {
    int upperBound = 1000, wordCount = 0;
    wordCount = IntStream.rangeClosed(1, upperBound)
                  .map((x) -> wordCountOfNo(Integer.toString(x)))
                  .sum();

    System.out.println("The total word count for all numbers between 1 and "
                          +upperBound+ " is: " +wordCount);
  }

  private static int wordCountOfNo(String num) {
    String[] numString = num.split("");
    int wordCount = 0, number = Integer.parseInt(num);
    for(int index = 0; index < numString.length; index++) {
      //Variable to hold the number in the current element:
      int currentNo = Integer.parseInt(numString[index]);

      //Variable to hold the current element index of number:
      int indexDif = (numString.length-1)-index;

      //First 'if' clause to get word count of numbers greater than 99:
      if(indexDif >= 2 && currentNo != 0) {
        wordCount += words.get((int) Math.pow(10,indexDif)).length();
        wordCount += words.get(currentNo).length();
      }
      //'else-if' to get word count of numbers between 20 and 99:
      else if(indexDif < 2 && currentNo != 0 && (number%100) > 19) {
        wordCount += words.get(currentNo * (int) Math.pow(10, indexDif)).length();
      }
    }

    //'if' clause to get word count of numbers between 1 and 19 inclusive:
    if(number % 100 < 20 && (number%100) != 0) {
      wordCount += words.get(number%100).length();
    }

    //Add 'and' to word count if the number is greater than 100 and non-zero:
    return (number>100 && (number%100)!=0)? wordCount+3: wordCount;
  }
}