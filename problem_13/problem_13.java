/* Work out the first ten digits of the sum of one-hundred 50-digit numbers.
*/

import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class problem_13 {
  public static void main(String args[]) {
    int digitNo = 10;

    //Reads the file containing the one-hundred 50-digit numbers:
    String fileName = "<Path Omitted>/java-examples/Project_Euler/problem_13.txt";
    try(Stream<String> stream = Files.lines(Paths.get(fileName))) {
      //Converts the stream of strings into a string array:
      String[] arrayOfNo = stream.toArray(String[]::new);

      //Extra digit buffer added to calculate the first x digits correctly:
      int digitBuffer = digitNo + (int) Math.ceil(Math.log10(arrayOfNo.length));
      long total = 0l;
      for(String element:arrayOfNo) {
        total += Long.parseLong(element.substring(0, digitBuffer));
      }

      System.out.println("The first " +digitNo+ " digits are: "
                          +String.valueOf(total).substring(0,10));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
