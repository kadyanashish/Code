package lecture5;

import java.util.Scanner;

public class loweruppercase {
	    public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        
	        char ch = scn.next().charAt(0);
	        
	        System.out.println(type(ch));
	     }
	
	     public static char type(char ch){
	        char retVal = '\0';
	        if(ch>='a'&&ch<='z'){
	            retVal='L';
	        }
	        else if(ch>='A'&&ch<='Z'){
	            retVal='u';
	        }
	         else{
	  retVal='I';
	  }
	        
	        return retVal;
	     }
	}


