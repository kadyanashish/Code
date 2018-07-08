package lecture4;

import java.util.Scanner;

public class integralpartofn {


    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      
      int N = scn.nextInt();
      
      System.out.println(squareRoot(N));
   }

   public static int squareRoot(int N) {
      int sqroot = 0;
      int i=0;
while (i * i <= N) {
			sqroot = i;
			i++;

		}
      return sqroot;
   }

}
