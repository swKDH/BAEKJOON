import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// 유니온 파이프 알고리즘
public class bj1717 {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1]; // 배열 초기화
		for(int i=1; i<=n; i++) parent[i] = i;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 결과 출력
			if(check == 1) {
				boolean equals = equalsparent(a, b);
				if(equals == true) System.out.println("YES");
				else System.out.println("NO");
			}
			// check == 0 일 때 집합 합침
			else union(a,b);
		}
		bf.close();
	}
	// 최상위 부모 찾기
	private static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	// 집합 합치기(트리 구조로 합치기)
	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x < y) parent[y] = x; // 작은 수가 부모 노드가 되도록 한다
		else parent[x] = y;
	}
	// 같은 집합인지 확인
	private static boolean equalsparent(int a, int b) {
		int x = find(a);
		int y = find(b);
		return x == y; // x,y 같으면 true 아님 false
	}
}
