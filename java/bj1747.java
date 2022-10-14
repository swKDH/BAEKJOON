import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1747 {
	
	static boolean[] arr = new boolean[1003002];
	
	static boolean isPanlindrome(int n) {
		int arr[] = new int[7], i = 0;
		while(n > 0) {
			arr[i] = n % 10;
			n /= 10; i++;
		}
		
		int lp = 0, rp = i - 1;
		while(lp <= rp) {
			if(arr[lp] != arr[rp]) {
				return false;
			}
			lp++; rp--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		arr[0] = true; arr[1] = true;
		
		for (int i = 2; i <= 1015; i++) { 
			if(!arr[i]) {
				for (int j = i * 2; j <= 1003001; j += i) {
					arr[j] = true;
				}
			}
		}
		
		while(N <= 1003001) {
			if(!arr[N] && isPanlindrome(N)) {
				System.out.println(N);
				break;
			}
			N++;
		}
	}
}