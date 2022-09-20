import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		int result = (int) (max - min + 1); //배열의 수
		int sqrt = ((int) Math.sqrt(max)); //최댓값을 제곱한 결과
		
		boolean[] checks = new boolean[result]; // 제곱 ㄴㄴ수가 아님을 체크. false : 제곱ㄴㄴ수, true : 제곱ㄴㄴ수가 아님.
		long[] num = new long[result];
		 
		
		for(long i = 2; i <= sqrt; i++) { //2-100
				long squared = i * i;//4
				long start = min % squared == 0 ? min / squared : (min / squared) + 1;//min이 제곱수로 나누어 떨어지면 min 부터 아니면 +1더한값을 제곱수로 곱하면 min보다 크면서 가장 작은 제곱수의 곱 구할수있다.
				for(long j = start; j * squared <= max; j ++) {	// 몫을 1씩 증가시킴( j가 몫 )
					checks[(int) ( (j * squared) - min)] = true; //이미 카운트한 수 중복방지 위해 true로 할당
				}
		}
		
		// 제곱ㄴㄴ수 개수 counting
		int count = 0;
		for(int i = 0; i < result; i++) {
			if(!checks[i])
				count++;
		}
		
		System.out.println(count);
	}
}