package ��°��;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class bj1260 {

	static StringBuilder sb = new StringBuilder();
	static  int [][]arr;//���� �������
	static boolean []check;//Ȯ��
	static int v, e, start;// ����, ����, ��������
	
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start= Integer.parseInt(st.nextToken());

		arr = new int[v+1][v+1];//��ǥ�� �ޱ� ���� +1
		check = new boolean[v+1];//�ʱⰪ false

		//�׷��� ����
		for(int i=0;i<e;i++) {
			StringTokenizer str = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());

			arr[x][y] = arr[y][x] = 1;

		}

		dfs(start);
		check = new boolean[v+1]; //Ȯ�λ��� �ʱ�ȭ
		sb.append("\n");
		bfs(start);
		System.out.println(sb);		
	}
	
	//�������� ������ �޾� Ȯ��, ��� �� ���� �������� ã�� �������� �����Ͽ� ��ȣ��
	public static void dfs(int start) {

		check[start] = true;
		sb.append(start + " ");

		for(int i = 0 ; i <= v ; i++) {
			if(arr[start][i] == 1 && check[i]==false)//arr=1�̸� ������ �ִٴ� ��/check�� false�� Ž������ ���� ����
				dfs(i);
		}
	}
	
	public static void bfs(int start) {
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();//ť�� ��ȯ���ش�
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
