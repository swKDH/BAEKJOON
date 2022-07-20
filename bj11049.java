package 셋째주;

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
		//i : 행렬의 개수가 n이라면 구간 간격은 2~ n까지 나눌 수 있다.
		//j : 구간 길이가 i이기 때문에 구간의 시작 행렬은 0~ n-i까지 가능하다
		//if n=4, i=2 라면 j는 0~1(AB), 1~2(BC), 2~3(CD)의 구간으로 나눌 수 있다. 
		//k : 구간의 시작부터 끝까지(j ~ j+i-1) 중간 지점을 설정하여 해당 구간의 곱셈 연산의 최솟값을 구한다.  
		//dp[j][k]  + dp[k+1][j+i-1] : (j ~ k), (k+1 ~ j+i-1)의 행렬의 곱셈 연산 최솟값을 더해준다.
		//(data[j]*data[k+1]*data[j+i]) : (j ~ j+i-1)행렬의 곱셈이 이루어지면서 새로운 값을 더해준다 맞나? 몰루
		//기존값과 비교하여 작으면 값을 바꿔준다?
		for(int i=2; i<n+1; i++) { // 구간 간격  
			for(int j=0; j<n-i+1; j++) { // 구간 시작점 j (0~n-i))
				dp[j][j+i-1] = INF;
				for(int k=j; k<j+i-1; k++) { // 중간 지점 k (j~ j+i-1))
					int value = dp[j][k]  + dp[k+1][j+i-1] + (data[j]*data[k+1]*data[j+i]);
					dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
				}
			}
		}
		System.out.println(dp[0][n-1]);
		
	}
}