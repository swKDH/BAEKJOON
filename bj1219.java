import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1219 {
	static int startcity, endcity, N, M;
	static long[] haveMoney, val;
	static long[][] cost;
	static final int INF = Integer.MIN_VALUE, GEE = Integer.MAX_VALUE; // 최소 금액과 최대 금액
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		startcity = Integer.parseInt(st.nextToken()); // 출발 도시
		endcity = Integer.parseInt(st.nextToken()); // 도착 도시        
		M = Integer.parseInt(st.nextToken()); // 교통수단의 개수
		haveMoney = new long[N]; // 각 도시에서 가지고 있는 돈의 최대값
		val = new long[N]; // 각 도시에서 벌 수 있는 돈
		Arrays.fill(haveMoney, INF); // Arrays.fill 배열의 값을 모두 같은 값으로 초기화
		cost = new long[N][N];
		// cost 2차원 배열 값을 모두 INF로  초기화
		for(int i=0; i<N; i++) for(int j=0; j<N; j++) cost[i][j] = INF;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 시작 도시
			int to = Integer.parseInt(st.nextToken()); // 도착 도시
			int weight = Integer.parseInt(st.nextToken()); // 교통 수단 비용
			cost[from][to] = Math.max(cost[from][to], -weight); // from도시에서 to도시까지의 비용을 나타낸 것  
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) val[i] = Integer.parseInt(st.nextToken()); // 각 도시에서 벌 수 있는 돈

		MaxMoney();
		br.close();
	}



	public static void MaxMoney() {
		haveMoney[startcity] = val[startcity]; // 시작 도시에서 가지고 있는 돈
		// 도시들 간의 경로가 여러 가지 있을 수 있어서 충분한 회수로 N의 최대 크기 만큼 더해준 회수를 반복해준다
		for (int n = 0; n < N + 50; n++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (haveMoney[i] == INF || cost[i][j] == INF) continue; // 갈 수 없는 경로
					// 이전 도시에서 이미 돈이 무수히 많다면 다음 도시에 도착했을 때도 돈이 무수히 많다
					else if (haveMoney[i] == GEE) haveMoney[j] = GEE; 
					else if (haveMoney[i] + cost[i][j] + val[j] > haveMoney[j]) { // 경로가 있을 경우
						// 다음 도시에 가지고 있는 돈 = 이전 도시에서 가지고 있돈 돈 + (-교통 비용) + 다음 도시에서 벌어들이는 돈
						haveMoney[j] = haveMoney[i] + cost[i][j] + val[j]; 
						// cycle이 생긴 경우, cycle이 생기면 endcity에 도착시 금액을 무수히 많이 가질 수 있다 
						if (n >= N - 1) haveMoney[j] = GEE;
					}
				}
			}
		}
		if (haveMoney[endcity] == INF) System.out.println("gg"); // 마지막 도시에 도착하지 못한 경우
		else if (haveMoney[endcity] == GEE) System.out.println("Gee");// 마지막 도시에 도착했지만 금액이 무수히 많은 경우
		else System.out.println(String.valueOf(haveMoney[endcity])); // 그 외의 나머지 경우
		return;
	}
}
