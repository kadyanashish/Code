package hashing;

import java.util.HashMap;
import java.util.Vector;

public class twouniquemaxsub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getmax("aabbcdeff"));
	}
	public static int getmax(String str)
	{
		Vector<Character> vec =new Vector<>();
		
		
		char prev = str.charAt(0);
		
		int ch = 1;
		int max = 0;
		int counter =1;
		int index =0;
		
		int f1=0 ;
		int f2=0;
		
		for(int i=0;i<str.length();i++)
		{
			if(vec.size()<2)
				f1++;
			if(vec.size()<3)
				vec.add(str.charAt(i));
			
			
			
			
		}
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)==prev)
			{
				counter++;
				
				if(counter>max)
					max=counter;
				
			}
			else if(ch<2)
			{
                 counter++;
                 
				if(counter>max)
					max=counter;
				
				index =i;
				ch++;
			}
			else
			{
				ch=2;
				counter++;
				counter = counter-index;
				
				if(counter>max)
					max = counter;
			}
		}
			
		return counter;
	}

}
