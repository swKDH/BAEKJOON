import java.io.*;
import java.util.*;

public class bj14425 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		int cnt=0;
		
		for(int i=0; i<n; i++) {
			map.put(br.readLine(), 0);
		}
		
		for(int i=0; i<m; i++) {
			if(map.containsKey(br.readLine())) cnt++;
		}
		
		
		System.out.println(cnt);

	}

}
