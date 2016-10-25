/* The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
so the first ten triangle numbers are:

                1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical
position and adding these values we form a word value. For example, the word value
for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then
we shall call the word a triangle word.

Using problem_42.txt, a 16K text file containing nearly two-thousand common English
words, how many are triangle words?
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class problem_42 {
  public static void main(String args[]) {
    int count = 0;

    ArrayList<Integer> triangleNos = new ArrayList<Integer>();
    for(int i = 0; i < 1001; i++) {
      triangleNos.add((((i+1)+1) * (i+1))/2);
    }

    String fileName = "<Path Omitted>/Project_Euler/problem_42.txt";
    try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
      //Split the read line into names without the quotation marks and commas:
      String[] words = read.readLine().replace("\"", "").split(",");

      for(int i = 0; i < words.length; i++) {
        if(triangleNos.contains(getAlphabeticalValue(words[i])))
          count++;
      }
      System.out.println("The number of triangle words in the file is: "+count);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  private static int getAlphabeticalValue(String word) {
    int value = 0;

    char[] letters = word.toCharArray();
    for(char letter:letters) {
      value += (letter - 'A' + 1);
    }
    return value;
  }
}