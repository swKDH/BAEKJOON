import java.io.*;
import java.util.StringTokenizer;

public class bj1389 {
    static int INITIAL_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1]; // 배열 생성

        // 초기값 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INITIAL_VALUE / 2; // 2차원 배열 초기화
                if (i == j)
                    arr[i][j] = 0; // (i,i)인 값 0으로
            }
        }

        // 간선의 방향이 양방향이어야 함.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A][B] = arr[B][A] = 1; // A와 B가 친구이면 B와 A도 친구다
        }

        // floyd
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) // minimum
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int result = INITIAL_VALUE;
        int idx = -1;
        // 가장 작은 값을 가지는 인덱스 찾기
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += arr[i][j];
            }
            if (result > total) {
                result = total;
                idx = i;
            }
        }
        System.out.println(idx);
        br.close();
    }
}
