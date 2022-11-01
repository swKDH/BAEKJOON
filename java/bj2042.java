import java.io.*;
import java.util.StringTokenizer;

public class bj2042 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		while(true) {
			if(m==0 && k==0) break;
			
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if(op ==1) {
				int idx = Integer.parseInt(st.nextToken())-1;
				long num = Long.parseLong(st.nextToken());
				arr[idx] = num; 
				m--;
			}else {
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken());
				
				long sum =0;
				for(int i = start; i<end; i++) {
					sum += arr[i];
				}
				sb.append(sum+"\n");
				k--;
			}
		}
		
		System.out.println(sb.toString());
	}
}