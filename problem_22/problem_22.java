/* Using problem_22.txt, a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical
value for each name, multiply this value by its alphabetical position in the
list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is
worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
*/

import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class problem_22 {
  public static void main(String args[]) {
    String fileName = "/Users/Chung/Documents/java-examples/Project_Euler/problem_22.txt";
    long total = 0l;

    try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
      //Split the read line into names without the quotation marks and commas:
      String[] names = read.readLine().replace("\"", "").split(",");

      //Sort names alphabetically:
      Arrays.sort(names);

      for(int i = 0; i < names.length; i++) {
          total += (long) (getAlphabeticalValue(names[i]) * (i+1));
      }

    } catch(IOException e) {
      e.printStackTrace();
    }
    System.out.println("The total of all the name scores in the file is: " +total);
  }

  private static int getAlphabeticalValue(String name) {
    char[] letters = name.toCharArray();
    int value = 0;

    for(int i = 0; i<letters.length; i++) {
      value += (letters[i] - 'A' + 1);
    }
    return value;
  }
}