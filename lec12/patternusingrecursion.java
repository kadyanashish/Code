package lec12;

public class patternusingrecursion {

	public static void main(String[] args) {

	}
public static void printpattern(int n,int r,int c){
	if(r==n){
		return;
	}
	else{
		System.out.print("*");
	}
	 printpattern(n,r++,c++);
}
}
