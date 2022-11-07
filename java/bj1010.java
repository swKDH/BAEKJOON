import java.io.*;
import java.util.*;

public class bj1010 {
	
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		int n, m;
		
		
		for(int i=0; i<t; i++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			long result = 1;
			
			for(int j=0; j<n; j++) {
				result *= (m-j);
				result /= (j+1);
			}
			
			System.out.println(result);
		}
		bw.close();
		sc.close();
	}
		
}
	
