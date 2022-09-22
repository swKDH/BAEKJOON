import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1043 {
		public static ArrayList<Integer>[] party;
		public static int[] parent;
		public static int[] trueP;
		public static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 

		result = 0;

		st = new StringTokenizer(br.readLine()); 
		int True = Integer.parseInt(st.nextToken()); 
		int trueP[] = new int[True];
		for(int i=0; i<True; i++){ 
			trueP[i] = Integer.parseInt(st.nextToken());
		}

		party = new ArrayList[M];
		for(int i=0; i<M; i++){ 
			party[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int party_size = Integer.parseInt(st.nextToken());
			for(int j=0; j<party_size; j++){
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		parent = new int[N+1];
		for(int i=0; i<=N; i++){ 
			parent[i] = i;
		}

		for(int i=0; i<M; i++){
			int firstP = party[i].get(0);
			for(int j=1; j<party[i].size(); j++){
				union(firstP, party[i].get(j)); 
			}
		}

		for(int i=0; i<M; i++){
			boolean isPossible = true;
			int cur = party[i].get(0);
			for(int j=0; j<trueP.length; j++){
				if(find(cur) == find(trueP[j])){
					isPossible = false;
					break;
				}
			}
			if (isPossible) result++;
		}

		System.out.println(result);
	}

	public static void union(int a, int b){ 
		a = find(a);
		b = find(b);
		if(a != b){
			parent[b] = a;
		}
	}

	public static int find(int a){
		if(a == parent[a]){
			return a;
		}else{
			return parent[a] = find(parent[a]);
		}
	}
}
