import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), "-"); // -�� �������� ��ūȭ
        int sum = 0; // ���
        Boolean fst = true; // ó�� ���� �� �Ǻ�
        while (st.hasMoreTokens()) { // ��ū�� ���������� �ݺ�
            int temp = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+"); // +�� �������� ��ūȭ
            while (st2.hasMoreTokens()) {   // ��ū�� ���������� �ݺ�
                temp += Integer.parseInt(st2.nextToken());   // -##(??+??+??) -�� ??�� ���
            }
            if (fst) {
                sum = temp; // ó�� ��
                fst = false;
            } else {
                sum -= temp; // ����
            }
        }
        System.out.println(sum);
        bf.close();
    }
}