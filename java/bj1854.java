import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1854 {
	
	static PriorityQueue<int[]> minheap = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[0], o2[0]);
		}
	});
	static ArrayList<int[]>[] graph = new ArrayList[1001];
	static PriorityQueue<Integer>[] cost = new PriorityQueue[1001];
	
	
	
	static void dijkstra(int start, int K) {
		cost[start].add(0);
		int[] a = {0, start};
		minheap.add(a);

		while (!minheap.isEmpty()) {
			int index = minheap.peek()[1];
			int value = minheap.peek()[0];
			minheap.poll();

			for (int i = 0; i < graph[index].size(); i++) {
				int next = graph[index].get(i)[0];
				int nextcost = value + graph[index].get(i)[1];

				if (cost[next].size() >= K) {
					if (cost[next].peek() <= nextcost) {
						continue;
					}
					cost[next].poll();
				}

				cost[next].add(nextcost);
				int[] b = {nextcost, next};
				minheap.add(b);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
			cost[i] = new PriorityQueue<>(Comparator.reverseOrder());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int a[] = {v, w};
			graph[u].add(a);
		}
		
		dijkstra(1, K);

		for (int i = 1; i <= V; i++) {
			if(cost[i].size() >= K) {
				System.out.println(cost[i].peek());
			}
			else {
				System.out.println(-1);
			}
		}
	}
}
