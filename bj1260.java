package 둘째주;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class bj1260 {

	static StringBuilder sb = new StringBuilder();
	static  int [][]arr;//간선 연결상태
	static boolean []check;//확인
	static int v, e, start;// 정점, 엣지, 시작정점
	
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start= Integer.parseInt(st.nextToken());

		arr = new int[v+1][v+1];//좌표를 받기 위해 +1
		check = new boolean[v+1];//초기값 false

		//그래프 생성
		for(int i=0;i<e;i++) {
			StringTokenizer str = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());

			arr[x][y] = arr[y][x] = 1;

		}

		dfs(start);
		check = new boolean[v+1]; //확인상태 초기화
		sb.append("\n");
		bfs(start);
		System.out.println(sb);		
	}
	
	//시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
	public static void dfs(int start) {

		check[start] = true;
		sb.append(start + " ");

		for(int i = 0 ; i <= v ; i++) {
			if(arr[start][i] == 1 && check[i]==false)//arr=1이면 간선이 있다는 뜻/check가 false면 탐색하지 않은 정점
				dfs(i);
		}
	}
	
	public static void bfs(int start) {
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();//큐를 반환해준다
			sb.append(start + " ");
			
			for(int i = 1 ; i <= v ; i++) {
				if(arr[start][i] == 1 && check[i]==false) {
					q.add(i);
					check[i] = true;
				}
			}
		}	
	}

}
