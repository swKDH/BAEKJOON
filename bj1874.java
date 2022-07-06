package Ã¹Â°ÁÖ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1874 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		String s = bf.readLine();
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			sum += s.charAt(i)-'0'; // -48
		}
		System.out.println(sum);
	}

}
