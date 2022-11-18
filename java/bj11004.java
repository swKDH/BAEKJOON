import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //배열개수
		int k = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = Integer.parseInt(st.nextToken()); //배열값 입력
		}		
		
		Arrays.sort(a);
		System.out.println(a[k-1]);
	}

}
