public class problem_2{
  public static void main(String args[]) {
    int a = 1, b = 2, c = 0, sum = 0;
    while(b<4000000){
      if (b % 2 == 0) sum += b;
      c = a+b;
      a = b;
      b = c;
    }

    System.out.println("The sum is: " +sum);
  }
}
