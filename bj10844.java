package ��°��;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class bj10844 {
	
	static long div = 1000000000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long[][] dp = new long[N + 1][10];
		
		 
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; // ù ��° �ڸ����� ������ �� ���� �ڸ����̹Ƿ� ����� ���� 1���ۿ� ����
		}
		
		
		for(int i = 2; i <= N; i++) { // �� ��° �ڸ������� N���� Ž�� 
			
			 
			for(int j = 0; j < 10; j++) { // i��° �ڸ����� �ڸ������� Ž�� (0~9)
				
				 
				if(j == 0) { //�ڸ����� 0�̶�� ���� �ڸ����� ù��° �ڸ����� ����
					dp[i][0] = dp[i - 1][1] % div;
				}
				
				else if (j == 9) { // j=9�� ���� �ڸ����� 8�� ����
					dp[i][9] = dp[i - 1][8] % div;
				}
				 
				else { // �� ���� ��� ���� �ڸ����� �ڸ��� +1, -1 �� ���� ��
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % div;
				}
			}
		}
		
		long result = 0;
		
		
		for(int i = 0; i < 10; i++) { // �� �ڸ��������� ����� ���� ��� ����
			result += dp[N][i];
		}
		
		System.out.println(result % div);
	}
 
}
