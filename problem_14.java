/* The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains
10 terms. Although it has not been proved yet (Collatz Problem), it is thought
that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

public class problem_14 {
  public static void main(String args[]) {
    //Upper bound of the number (one million):
    int maxNo = 1000000;

    //Initialising the largest chain and its number:
    long largestChain = 1;
    int longChainNo = 1;

    //Since '1' and '2' are reached by all numbers, the numbers were omitted:
    for(int i = 3; i < maxNo; i++) {
      long currentChain = getChainSize(i);

      if(currentChain > largestChain) {
        largestChain = currentChain;
        longChainNo = i;
      }
    }

    System.out.println("The number under one million that produces the largest chain is: "
                        +longChainNo);
  }

  private static long getChainSize(int num) {
    long number = num, chainSize = 1;
    while(number > 1) {
      if(number%2 == 0) {
        number = number >> 1;
        chainSize++;
      }
      else {
        //In the sequence, an odd number is reduced to an even number.
        //Hence, the even sequence is applied after the odd sequence.
        number = ((3*number)+1) >> 1;
        chainSize += 2;
      }
    }
    return chainSize;
  }
}