import java.io. BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1850 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long k = G(n,m);
		for(long i=1; i<=k; i++) sb.append("1");
		System.out.println(sb);
	}
	private static long G(long a, long b) {
		if(b ==0 ) return a; //나머지가 0이면 작은 숫자가 최대공약수이므로 작은숫자 리턴
		return G(b, a%b); // 나머지가 0이상이면 큰숫자를 작은숫자로 나눈 나머지로 재귀 호출
	}
}
