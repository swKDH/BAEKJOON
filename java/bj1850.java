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
		if(b ==0 ) return a; //�������� 0�̸� ���� ���ڰ� �ִ������̹Ƿ� �������� ����
		return G(b, a%b); // �������� 0�̻��̸� ū���ڸ� �������ڷ� ���� �������� ��� ȣ��
	}
}
