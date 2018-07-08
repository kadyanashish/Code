package lecture5;

import java.util.Scanner;

public class precisonsqroot {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int N = scn.nextInt();
        int P = scn.nextInt();
        
        System.out.println(squareRoot(N, P));
     }
     
     public static double squareRoot(int n, int precision) {
        double sqroot = 0;;
        int i = 0;
  		while (i * i <= n) {
  			sqroot = i;
  			i++;
  		}
  		double dec = 1, finalans = 0;
  		for (int j = 0; j < precision; j++) {
  			dec /= 10;
  			sqroot = sqroot + dec;
  			while (sqroot * sqroot <= n) {
  				finalans = sqroot;
  				sqroot = sqroot + dec;
  			}
  			sqroot = sqroot - dec;
  		}
  		int roundmul = 1;
  		double downmul=1.0;
  		for (int j = 0; j < precision; j++) {
  			roundmul *= 10;
  			downmul*=10.0;
  		}
  	return (Math.round((finalans * roundmul)) / ( downmul));
      
     }
}