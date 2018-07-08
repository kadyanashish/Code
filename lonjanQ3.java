import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class lonjanQ3 {
Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int t=0;
		t=sc.nextInt();
		for (int i = 0; i < t; i++) {
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
			String[] s=(br.readLine()).split(" ");

			int K=Integer.parseInt(s[0]);

			int N=Integer.parseInt(s[1]);
			int[] arr=new int[N];
			for (int j = 0; j < N; j++) {
				arr[i]=sc.nextInt();
			}
			System.out.println(result(arr,K));
			
		}
		
		
	}

	private static int result(int[] arr, int k) {

		int result = arr[0];
		int[] res=maxsub(arr);
		
		
		
		
		return result;
	}
	public static int[] maxsub(int[] array) {
		int[] res = new int[3];
		// int[] array = { -2, -3, 4, -1, -2, 1, 5, -3, 4 };
		int maxsum = array[0];
		int currsum = 0;
		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < array.length; i++) {
			int x = array[i];
			currsum += x;
			if (currsum > maxsum) {
				maxsum = currsum;
				start = s;

				end = i;
			}
			if (currsum < 0) {
				currsum = 0;
				s = i + 1;

			}

		}

		System.out.println(maxsum);
		System.out.println(start);
		System.out.println(end);

		res[0] = maxsum;
		res[1] = start;
		res[2] = end;
		return res;
	}


}
