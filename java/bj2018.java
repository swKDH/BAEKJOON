import java.util.*;

public class bj2018 {	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int start = 1, end = 1, sum = 1, cnt = 0;
		
		while(start <= end) {
			
			if(sum == num) {
				cnt++;
				
			}
			
			if(sum < num) {
				end++;
				sum += end;
				
			}
			else{
				sum -= start;
				start++;
			}
		}
		System.out.println(cnt);
		sc.close();
		
	}

}
