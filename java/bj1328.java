import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1328 {
	static long[][][] dp;
	static int div = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 빌딩의 개수
		int l = Integer.parseInt(st.nextToken()); // 왼쪽에서 보았을  빌딩의 개수 
		int r = Integer.parseInt(st.nextToken()); // 오른쪽에서 보았을 때 빌딩의 개수
		dp = new long[n+1][n+1][n+1];
		dp[1][1][1] = 1; // 빌딩의 개수가 1개일 경우
		// 빌딩의 크기를 1씩 계속 증가 시키고 매번 크기가 1인 빌딩을 세우는 방식으로 문제를 해결함
		for (int i = 2;i< n+1; i++) {
		       dp[i][i][1] = dp[i][1][i] = 1;
		       
		       // 왼쪽 빌딩 수가 n개이고 오른쪽 빌딩 수가 1인 경우는 하나 뿐이다
		       // 오른쪽 빌딩 수가 n개이고 왼쪽 빌딩 수가 1인 경우는 하나 뿐이다
		       for (int j = 1; j< l+1; j++) {
		           for (int k = 1; k< r+1; k++) {
// 왼쪽의 개수가 달라졌을 (왼쪽에 n 번째 빌딩(크기가 1인 빌딩)을 세우는 경우), 오른쪽 건물의 개수가 달라졌을 때(오른쪽에 n 번째 빌딩을 세우는 경우), 
// 왼쪽과 오른쪽 건물의 개수는 변화 없고 건물의 개수가 변했을 경우(양 끝을 제외하고 나머지 장소에 건물을 세우는 경우)
		        	   //N = 4이면 N = 3일 때 크기 1인 빌딩을 추가해주는 방식으로 N = 4일 의 경우의 수를 구하자( DP 방식이다)
		               dp[i][j][k] = (dp[i - 1][j][k-1] + dp[i - 1][j - 1][k]
		               			+ (dp[i - 1][j][k] * (i-2)))%div; // i-2는 나무 사이의 공간 개수
		           }
		       }
		}
		System.out.println(dp[n][l][r]);
	}
}

