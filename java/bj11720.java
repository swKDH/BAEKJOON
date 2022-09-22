package 첫째주;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11720 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		String[] s = bf.readLine().split(""); //split 사용하여 배열로 입력 받음
		int sum = 0;
		
		for(int i=0;i<N;i++) {//배열의 합 계산
			sum += Integer.parseInt(s[i]);
		
		}
		System.out.println(sum);
	}

}
