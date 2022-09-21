import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1219 {
	static int startcity, endcity, N, M;
	static long[] haveMoney, val;
	static long[][] cost;
	static final int INF = Integer.MIN_VALUE, GEE = Integer.MAX_VALUE; // �ּ� �ݾװ� �ִ� �ݾ�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ������ ����
		startcity = Integer.parseInt(st.nextToken()); // ��� ����
		endcity = Integer.parseInt(st.nextToken()); // ���� ����        
		M = Integer.parseInt(st.nextToken()); // ��������� ����
		haveMoney = new long[N]; // �� ���ÿ��� ������ �ִ� ���� �ִ밪
		val = new long[N]; // �� ���ÿ��� �� �� �ִ� ��
		Arrays.fill(haveMoney, INF); // Arrays.fill �迭�� ���� ��� ���� ������ �ʱ�ȭ
		cost = new long[N][N];
		// cost 2���� �迭 ���� ��� INF��  �ʱ�ȭ
		for(int i=0; i<N; i++) for(int j=0; j<N; j++) cost[i][j] = INF;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // ���� ����
			int to = Integer.parseInt(st.nextToken()); // ���� ����
			int weight = Integer.parseInt(st.nextToken()); // ���� ���� ���
			cost[from][to] = Math.max(cost[from][to], -weight); // from���ÿ��� to���ñ����� ����� ��Ÿ�� ��  
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) val[i] = Integer.parseInt(st.nextToken()); // �� ���ÿ��� �� �� �ִ� ��

		MaxMoney();
		br.close();
	}



	public static void MaxMoney() {
		haveMoney[startcity] = val[startcity]; // ���� ���ÿ��� ������ �ִ� ��
		// ���õ� ���� ��ΰ� ���� ���� ���� �� �־ ����� ȸ���� N�� �ִ� ũ�� ��ŭ ������ ȸ���� �ݺ����ش�
		for (int n = 0; n < N + 50; n++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (haveMoney[i] == INF || cost[i][j] == INF) continue; // �� �� ���� ���
					// ���� ���ÿ��� �̹� ���� ������ ���ٸ� ���� ���ÿ� �������� ���� ���� ������ ����
					else if (haveMoney[i] == GEE) haveMoney[j] = GEE; 
					else if (haveMoney[i] + cost[i][j] + val[j] > haveMoney[j]) { // ��ΰ� ���� ���
						// ���� ���ÿ� ������ �ִ� �� = ���� ���ÿ��� ������ �ֵ� �� + (-���� ���) + ���� ���ÿ��� ������̴� ��
						haveMoney[j] = haveMoney[i] + cost[i][j] + val[j]; 
						// cycle�� ���� ���, cycle�� ����� endcity�� ������ �ݾ��� ������ ���� ���� �� �ִ� 
						if (n >= N - 1) haveMoney[j] = GEE;
					}
				}
			}
		}
		if (haveMoney[endcity] == INF) System.out.println("gg"); // ������ ���ÿ� �������� ���� ���
		else if (haveMoney[endcity] == GEE) System.out.println("Gee");// ������ ���ÿ� ���������� �ݾ��� ������ ���� ���
		else System.out.println(String.valueOf(haveMoney[endcity])); // �� ���� ������ ���
		return;
	}
}
