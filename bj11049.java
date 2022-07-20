package ��°��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11049 {
	static int n, INF = Integer.MAX_VALUE;
	static int[] data;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		data = new int[n+1];
		StringTokenizer st = null;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			data[i] = a; data[i+1] = b;
		}
		
		dp = new int[n][n];
		//i : ����� ������ n�̶�� ���� ������ 2~ n���� ���� �� �ִ�.
		//j : ���� ���̰� i�̱� ������ ������ ���� ����� 0~ n-i���� �����ϴ�
		//if n=4, i=2 ��� j�� 0~1(AB), 1~2(BC), 2~3(CD)�� �������� ���� �� �ִ�. 
		//k : ������ ���ۺ��� ������(j ~ j+i-1) �߰� ������ �����Ͽ� �ش� ������ ���� ������ �ּڰ��� ���Ѵ�.  
		//dp[j][k]  + dp[k+1][j+i-1] : (j ~ k), (k+1 ~ j+i-1)�� ����� ���� ���� �ּڰ��� �����ش�.
		//(data[j]*data[k+1]*data[j+i]) : (j ~ j+i-1)����� ������ �̷�����鼭 ���ο� ���� �����ش� �³�? ����
		//�������� ���Ͽ� ������ ���� �ٲ��ش�?
		for(int i=2; i<n+1; i++) { // ���� ����  
			for(int j=0; j<n-i+1; j++) { // ���� ������ j (0~n-i))
				dp[j][j+i-1] = INF;
				for(int k=j; k<j+i-1; k++) { // �߰� ���� k (j~ j+i-1))
					int value = dp[j][k]  + dp[k+1][j+i-1] + (data[j]*data[k+1]*data[j+i]);
					dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
				}
			}
		}
		System.out.println(dp[0][n-1]);
		
	}
}