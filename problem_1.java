import java.util.stream.IntStream;

public class problem_1 {
  public static void main(String args[]) {
    int sum = IntStream.range(0,1000)
      .filter(i-> i%3 == 0 || i%5 == 0)
      .sum();

    System.out.println("The sum is: " +sum);
  }
}
