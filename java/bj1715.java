import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //�켱����ť
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < n ; i++){
            int x = Integer.parseInt(bf.readLine());
            pq.add(x); // ���� �� readline���� �޾��ְ� �ٷ� ť�� ����
                       //add ��� offer�� ����ص� ����. offer�� �� ����
        }

        int answer = 0;
        while(pq.size() > 1){ // ť���� �ϳ��ۿ� ���ٸ� ����� �� �� ��� >1 �̶�� ������ �־���.
            int a = pq.poll(); // ù��° ��
            int b = pq.poll(); // �ι�° ��

            answer += a+b; // ���� �ΰ� ���Ѱ�
            pq.add(a+b); // �ΰ� ���� ���� �ٽ� ť�� ����
        }
        
        System.out.println(answer);
    }

}
