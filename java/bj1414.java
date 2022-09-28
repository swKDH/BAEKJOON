import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class bj1414{

	static class Node implements Comparable<Node>{ // 간선 정보
		int a;
		int b;
		int length;
		public Node(int a, int b, int length) {
			this.a = a;
			this.b = b;
			this.length = length;
		}
		@Override
		public int compareTo(Node o) { // 오름차순으로 정렬
		return this.length - o.length;
		}
	}
	static int n; // 컴퓨터 개수
	static int[] parents; // 부모노드
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 컴퓨터 개수
		
		char[][] map = new char[n][n];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		int total = 0;
		Queue<Node> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if('a' <= map[i][j] && map[i][j] <= 'z') {
					total += map[i][j]-96;
					pq.add(new Node(i+1,j+1, map[i][j]-96));
				}else if('A' <= map[i][j] && map[i][j] <= 'Z') {
					total += map[i][j]-38;
					pq.add(new Node(i+1,j+1, map[i][j]-38));
				}
			}
		}
		
		int size = pq.size();
		int cycle = 1; // n번이 되면 끝남.
		int result = 0;
		for(int i=0; i<size; i++) {
			Node node = pq.poll();
			int rx = find(node.a);
			int ry = find(node.b);
			
			if(rx != ry) {
				cycle++;
				result += node.length;
				union(node.a, node.b);
			}
		}
		if(cycle != n) {
			System.out.println(-1);
		}else {
			System.out.println(total-result);	
		}
	}
	
	static int find(int x) { 
		if (parents[x] == x) { 
			return x; 
	     } 
		return parents[x] = find(parents[x]);
	} 
	     
	static void union(int x, int y) {
		x = find(x); 
		y = find(y); 
	    if (x < y) { 
	    	parents[y] = x; 
	    } 
	    else { 
	    	parents[x] = y; 
	    } 
	}	
}
