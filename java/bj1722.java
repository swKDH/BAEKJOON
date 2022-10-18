import java.util.Arrays;
import java.util.Scanner;

public class bj1722 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long [] f = new long[21];
        boolean [] c = new boolean[21]; //n�� �ߺ��� ���� �����Ƿ� �ߺ��� ���� boolean �迭
        Arrays.fill(f, 1);
        
        for(int i=1; i<=20; i++) { //���丮�� ���ϱ�
            f[i] = f[i-1]*i;
        }
        
        int n = scan.nextInt();           //���ڸ��� �� ? 
        int what = scan.nextInt();			// 1�� ��� ���°�� ���ڰ� �ִ� �� , 2�� ��� ���ڰ� ���°�� �ִ���
        
        int [] a = new int[n];	
        if(what == 2) { //�� ��° ��������
            for(int i=0; i<n; i++)
                a[i] = scan.nextInt();
            
            long ans = 1; //������ 1 ��° ���� ����
            for(int i=0; i<n; i++) {
                for(int j=1; j<a[i]; j++) {
                    if(!c[j])
                        ans += f[n-i-1];
                }
                c[a[i]]=true; // ������ �����ϴ� ���ڴ� �ִٰ� ǥ�����ش�.
            }
            System.out.println(ans);
        }
        else if(what == 1) { //k ��° ���� ���
            long k = scan.nextLong();
            for(int i=0; i<n; i++) {
                for(int j=1; j<=n; j++) {
                    if(c[j]) 
                        continue;	//������ �̹� �����ϴ� ���ڸ� �Ѿ��
                    if(f[n-i-1] < k) {
                        k -= f[n-i-1]; // ���丮�� ���� k ���� ������ k ���� ���丮�� ���� ���ش�
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
