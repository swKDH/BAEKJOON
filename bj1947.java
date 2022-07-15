package ��°��;

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
				// dp[n-2] = ���� n�� ������ ��ȯ�ϴ� ���,
				// dp[n-1] = ���� n�� ������ ��ȯ�ߴµ�, ��, n�� �ٸ� ������ ������ �� ���
				// n-1 = �� �ٸ��ְ� n-1�� �ִ�.
				dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000000) * (i - 1) % 1000000000;
			}

			System.out.println(dp[N]);
		}
	}

}
