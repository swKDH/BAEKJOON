import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ��ȸ�� ����(SNS)
// DP + Ʈ��
public class bj2533 {
	static int n;
	static boolean[] visited;
	static List<Integer>[] graph;
	// dp : �ش� ���������� �󸮾���� �ο���(Ʈ�� �����̱� ������ �ڽ� ������ dp������ ���ؿ´�)
	static int[][] dp;	// [y][x]�� ��, y : ��� ��ȣ, x : 0 -> �ش� ����ȣ�� earlyAdaptor�� �ƴҶ�, 1 -> �ش� ����ȣ�� earlyAdaptor�� ��

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		dp = new int[n + 1][2];
		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}


		StringTokenizer st;
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}

		// Ʈ�� �����̱� ������ 1���� ����
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	static void dfs(int number) {
		visited[number] = true;
		dp[number][0] = 0;	// �ش� number�� �󸮾���Ͱ� �ƴ� ���
		dp[number][1] = 1;	// �ش� number�� �󸮾������ ���(�켱 ���� �� �ش� ���� �󸮾�����̹Ƿ� ���� 1)

		for(int child : graph[number]) {
			if(!visited[child]) {	// dfs �ߺ� �湮 ����(���ص��Ǵµ� Ȯ���غ���)
				dfs(child);	// dfs ���ȣ���� ���� �ڽ� ����� dp���� �̸� ���Ѵ�.
				dp[number][0] += dp[child][1];	// �ڽ� ��尡 ������ �󸮾���Ϳ����Ѵ�.
				dp[number][1] += Math.min(dp[child][0], dp[child][1]);	// �ֳ��ϸ� �ּ��� �󸮾���� �ο��� �̱� ������ �ڽ� ��尡 �󸮾���� �ϼ���, �ƴҼ��� �ִ�.
			}
		}
	}
}