import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1256 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long combin[][] = new long[201][201];
		String ans = "";
		
		for(int i=1; i<=N+M; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0 || j == i) {
					combin[i][j] = 1;
				}
				else if(j == 1 || j == i - 1) {
					combin[i][j] = i;
				}
				else {
					combin[i][j] = combin[i-1][j-1] + combin[i-1][j];
					
					if (combin[i][j] > 1e9) {
						combin[i][j] = (long)(1e9 + 1);
					}
				}
			}
		}
		
		if (combin[(int)(N + M)][(int) N] < K) {
			System.out.println(-1);
		}
		else {
			while (N > 0 && M > 0) {
				if (K <= combin[(int)(N + M - 1)][(int)(N - 1)]) {
					N--;
					ans += 'a';
				}
				else {
					K -= combin[(int)(N + M - 1)][(int)(N - 1)];
					M--;
					ans += 'z';
				}
			}
			
			while (N > 0) {
				N--;
				ans += 'a';
			}
			while (M > 0) {
				M--;
				ans += 'z';
			}
		}
		
		System.out.println(ans);
	}
}