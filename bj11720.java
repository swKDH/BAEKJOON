package ù°��;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11720 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		String[] s = bf.readLine().split(""); //split ����Ͽ� �迭�� �Է� ����
		int sum = 0;
		
		for(int i=0;i<N;i++) {//�迭�� �� ���
			sum += Integer.parseInt(s[i]);
		
		}
		System.out.println(sum);
	}

}
