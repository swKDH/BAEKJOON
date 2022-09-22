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
		int n = Integer.parseInt(st.nextToken()); // ������ ����
		int l = Integer.parseInt(st.nextToken()); // ���ʿ��� ������ �� ������ ���� 
		int r = Integer.parseInt(st.nextToken()); // �����ʿ��� ������ �� ������ ����
		dp = new long[n+1][n+1][n+1];
		dp[1][1][1] = 1; // ������ ������ 1���� ���
		// ������ ũ�⸦ 1�� ��� ���� ��Ű�� �Ź� ũ�Ⱑ 1�� ������ ����� ������� ������ �ذ���
		for (int i = 2;i< n+1; i++) {
		       dp[i][i][1] = dp[i][1][i] = 1;
		       
		       // ���� ���� ���� n���̰� ������ ���� ���� 1�� ���� �ϳ� ���̴�
		       // ������ ���� ���� n���̰� ���� ���� ���� 1�� ���� �ϳ� ���̴�
		       for (int j = 1; j< l+1; j++) {
		           for (int k = 1; k< r+1; k++) {
// ������ ������ �޶����� ��(���ʿ� n ��° ����(ũ�Ⱑ 1�� ����)�� ����� ���), ������ �ǹ��� ������ �޶����� ��(�����ʿ� n ��° ������ ����� ���), 
// ���ʰ� ������ �ǹ��� ������ ��ȭ ���� �ǹ��� ������ ������ ���(�� ���� �����ϰ� ������ ��ҿ� �ǹ��� ����� ���)
		        	   //N = 4�̸� N = 3�� �� ũ�� 1�� ������ �߰����ִ� ������� N = 4�� ���� ����� ���� ������( DP ����̴�)
		               dp[i][j][k] = (dp[i - 1][j][k-1] + dp[i - 1][j - 1][k]
		               			+ (dp[i - 1][j][k] * (i-2)))%div; // i-2�� ���� ������ ���� ����
		           }
		       }
		}
		System.out.println(dp[n][l][r]);
	}
}

