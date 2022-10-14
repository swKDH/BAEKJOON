import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// ���Ͽ� ������ �˰���
public class bj1717 {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1]; // �迭 �ʱ�ȭ
		for(int i=1; i<=n; i++) parent[i] = i;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// ��� ���
			if(check == 1) {
				boolean equals = equalsparent(a, b);
				if(equals == true) System.out.println("YES");
				else System.out.println("NO");
			}
			// check == 0 �� �� ���� ��ħ
			else union(a,b);
		}
		bf.close();
	}
	// �ֻ��� �θ� ã��
	private static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	// ���� ��ġ��(Ʈ�� ������ ��ġ��)
	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x < y) parent[y] = x; // ���� ���� �θ� ��尡 �ǵ��� �Ѵ�
		else parent[x] = y;
	}
	// ���� �������� Ȯ��
	private static boolean equalsparent(int a, int b) {
		int x = find(a);
		int y = find(b);
		return x == y; // x,y ������ true �ƴ� false
	}
}
