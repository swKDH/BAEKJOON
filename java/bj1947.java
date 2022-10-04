package 둘째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1947 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		long dp[] = new long[N + 1];

		if (N == 1)
			System.out.println(0);
		else {
			dp[1] = 0;
			dp[2] = 1;
			for (int i = 3; i <= N; i++) {
				// dp[n-2] = 내가 n과 선물을 교환하는 경우,
				// dp[n-1] = 내가 n과 선물을 교환했는데, 또, n이 다른 애한테 선물을 줄 경우
				// n-1 = 그 다른애가 n-1명 있다.
				dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000000) * (i - 1) % 1000000000;
			}

			System.out.println(dp[N]);
		}
	}

}
