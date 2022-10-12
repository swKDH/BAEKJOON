import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), "-"); // -를 기준으로 토큰화
        int sum = 0; // 결과
        Boolean fst = true; // 처음 더할 수 판별
        while (st.hasMoreTokens()) { // 토큰이 없을때까지 반복
            int temp = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+"); // +를 기준으로 토큰화
            while (st2.hasMoreTokens()) {   // 토큰이 없을때까지 반복
                temp += Integer.parseInt(st2.nextToken());   // -##(??+??+??) -뒤 ??들 계산
            }
            if (fst) {
                sum = temp; // 처음 수
                fst = false;
            } else {
                sum -= temp; // 빼기
            }
        }
        System.out.println(sum);
        bf.close();
    }
}