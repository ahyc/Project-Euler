/* By starting at the top of the triangle below and moving to adjacent numbers
on the row below, the maximum total from top to bottom is 23.

   3
  7 4
 2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

                            75
                          95 64
                        17 47 82
                      18 35 87 10
                    20 04 82 47 65
                  19 01 23 75 03 34
                88 02 77 73 07 63 67
              99 65 04 28 06 16 70 92
            41 41 26 56 83 40 80 70 33
          41 48 72 33 47 32 37 16 94 29
        53 71 44 65 25 43 91 52 97 51 14
      70 11 33 28 77 73 17 78 39 68 17 57
    91 71 52 38 17 14 91 43 58 50 27 29 48
  63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
*/

import java.util.stream.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Math;

public class problem_18 {
  public static void main(String args[]) {
    String fileName = "<Path Omitted>/Project_Euler/problem_18.txt";
    try(Stream<String> stream = Files.lines(Paths.get(fileName))) {
      //Converts the stream of strings into an int array:
      int[][] triangle = getArrayOfTri(stream.toArray(String[]::new));

      //'for' loop starts with the second last row (dynamic programming),
      //and adds to itself the largest adjacent element from the row beneath:
      int columnReduction = 1;
      for(int i = ((triangle.length-1)-columnReduction); i > -1; i--) {
        for(int j = 0; j<triangle[0].length - columnReduction; j++) {
          triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
        }
        //As the loops moves towards the origin of the triangle, the number of
        //columns reduces by one with each row:
        columnReduction++;
      }

      System.out.println("The maximum total of the triangle is: "
                            +triangle[0][0]);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Method splits the row and returns an int array of the elements:
  private static int[] getRow(String row) {
    return Arrays.asList(row.split(" ")).stream()
                    .mapToInt(Integer::parseInt)
                    .toArray();
  }

  //Method to return the triangle as a 2D array:
  private static int[][] getArrayOfTri(String[] stringOfTri) {
    String lastRow = stringOfTri[stringOfTri.length-1];
    int[][] array = new int[stringOfTri.length][getRow(lastRow).length];

    for(int i = 0; i < stringOfTri.length; i ++) {
      int[] currentRow = getRow(stringOfTri[i]);
      for(int j = 0; j < currentRow.length; j ++) {
        array[i][j] = currentRow[j];
      }
    }
    return array;
  }

}