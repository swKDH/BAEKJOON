import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class bj9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		int cnt = 3;
		int t = Integer.parseInt(br.readLine());
		for(int tt=0;tt<t;tt++) {
			int n = Integer.parseInt(br.readLine());
			if(n<=cnt) {
				sb.append(dp[n]).append("\n");
				continue;
			}
			
			for(int i=cnt+1;i<=n;i++) {
				dp[i] = dp[i-2]+dp[i-3];
			}
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
	
}            
