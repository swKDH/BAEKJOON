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
		
		int result = (int) (max - min + 1); //�迭�� ��
		int sqrt = ((int) Math.sqrt(max)); //�ִ��� ������ ���
		
		boolean[] checks = new boolean[result]; // ���� �������� �ƴ��� üũ. false : ����������, true : ������������ �ƴ�.
		long[] num = new long[result];
		 
		
		for(long i = 2; i <= sqrt; i++) { //2-100
				long squared = i * i;//4
				long start = min % squared == 0 ? min / squared : (min / squared) + 1;//min�� �������� ������ �������� min ���� �ƴϸ� +1���Ѱ��� �������� ���ϸ� min���� ũ�鼭 ���� ���� �������� �� ���Ҽ��ִ�.
				for(long j = start; j * squared <= max; j ++) {	// ���� 1�� ������Ŵ( j�� �� )
					checks[(int) ( (j * squared) - min)] = true; //�̹� ī��Ʈ�� �� �ߺ����� ���� true�� �Ҵ�
				}
		}
		
		// ���������� ���� counting
		int count = 0;
		for(int i = 0; i < result; i++) {
			if(!checks[i])
				count++;
		}
		
		System.out.println(count);
	}
}