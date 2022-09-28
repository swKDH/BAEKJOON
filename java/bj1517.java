import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1517 {
	static class SegmentTree {
		public int[][] segt;
		public int[] arr;
		
		SegmentTree(int n) {
			segt = new int[1050000][2];
			arr = new int[n + 1];
			arr[n] = Integer.MIN_VALUE;
		}
		
		int indata(int STindex, int Llim, int Rlim) { // O(2N)
			segt[STindex][1] = 0;
			
			if(Llim >= Rlim) {
				segt[STindex][0] = Rlim;
				return Rlim;
			}
			
			int half = (Llim + Rlim) / 2;
			int L_id = indata(STindex * 2, Llim, half);
			int R_id = indata(STindex * 2 + 1, half + 1, Rlim);
			
			segt[STindex][0] = arr[L_id] > arr[R_id] ? L_id : R_id;
			return segt[STindex][0];
		}
		
		int Ct_Minus(int STindex, int Llim, int Rlim, int start, int end) { // O(logN)
			if(Rlim < start || end < Llim) {
				return 0;
			}
			else if(start <= Llim && Rlim <= end) {
				return segt[STindex][1];
			}
			
			int out = 0;
			int half = (Llim + Rlim) / 2;
			out += Ct_Minus(STindex * 2, Llim, half, start, end);
			out += Ct_Minus(STindex * 2 + 1, half + 1, Rlim ,start, end);

			return out;
		}
		
		int query(int N) { // O(2logN)
			int out = N - segt[1][0];
			out -= Ct_Minus(1, 0, N, segt[1][0], N); // O(logN)
	        
			update(1, 0, N, N + 1); // O(logN)
			return out;
		}
		
		void update(int STindex, int Llim, int Rlim, int N) { // O(logN)
			if (Llim >= Rlim) {
				segt[STindex][0] = N;
				segt[STindex][1]++;
				return;
			}

			int half = (Llim + Rlim) / 2;
			if (segt[STindex][0] == segt[STindex * 2][0]) {
				update(STindex * 2, Llim, half, N);
			}
			else {
				update(STindex * 2 + 1, half + 1, Rlim, N);
			}
			segt[STindex][1]++;
			
			if (arr[segt[STindex * 2][0]] > arr[segt[STindex * 2 + 1][0]]) {
				segt[STindex][0] = segt[STindex * 2][0];
			}
			else {
				segt[STindex][0] = segt[STindex * 2 + 1][0];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N;
		long ans =0;
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		
		SegmentTree ST = new SegmentTree(N);
		
		for(int i = 0; i < N; i++) { // O(N)
			ST.arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ST.indata(1, 0, N - 1); // O(2N)
		
		for (int i = 0; i < N; i++) { // O(2NlogN)
			ans += ST.query(N - 1); // O(2logN)
		}
		
		System.out.println(ans);
	}
}