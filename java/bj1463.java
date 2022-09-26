
import java.io.*;

public class bj1463 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int D[] = new int[N+1];
		D[1] = 0;
		
		for(int n=2;n <= N; n++){
			
			D[n] = D[n-1] + 1;

		
			if(n % 2 == 0){
				D[n] = Math.min(D[n], D[n/2] + 1);
			}

			
			if(n % 3 == 0){
				D[n] = Math.min(D[n], D[n/3] + 1);
			}
		}

		System.out.println(D[N]);

	}
}