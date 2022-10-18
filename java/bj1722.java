import java.util.Arrays;
import java.util.Scanner;

public class bj1722 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long [] f = new long[21];
        boolean [] c = new boolean[21]; //n엔 중복된 수가 없으므로 중복을 없앨 boolean 배열
        Arrays.fill(f, 1);
        
        for(int i=1; i<=20; i++) { //팩토리얼 구하기
            f[i] = f[i-1]*i;
        }
        
        int n = scan.nextInt();           //몇자리의 수 ? 
        int what = scan.nextInt();			// 1의 경우 몇번째의 숫자가 있는 값 , 2의 경우 숫자가 몇번째에 있는지
        
        int [] a = new int[n];	
        if(what == 2) { //몇 번째 순열인지
            for(int i=0; i<n; i++)
                a[i] = scan.nextInt();
            
            long ans = 1; //순열은 1 번째 부터 시작
            for(int i=0; i<n; i++) {
                for(int j=1; j<a[i]; j++) {
                    if(!c[j])
                        ans += f[n-i-1];
                }
                c[a[i]]=true; // 순열에 존재하는 숫자는 있다고 표시해준다.
            }
            System.out.println(ans);
        }
        else if(what == 1) { //k 번째 순열 출력
            long k = scan.nextLong();
            for(int i=0; i<n; i++) {
                for(int j=1; j<=n; j++) {
                    if(c[j]) 
                        continue;	//순열에 이미 존재하는 숫자면 넘어간다
                    if(f[n-i-1] < k) {
                        k -= f[n-i-1]; // 팩토리얼 값이 k 보다 작으면 k 에서 팩토리얼 값을 빼준다
                    }
                    else {
                        a[i] = j;
                        c[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }	
}
