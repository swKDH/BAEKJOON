package 첫째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// K원을 만들기 위해 필요한 동전의 최소 개수 구하기
public class bj11047 {
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken()); // 동전 종류 N개
      int K = Integer.parseInt(st.nextToken()); // 금액 K원
      
      int Money[] = new int[N];
      for(int i=0; i<N; i++) {
         st = new StringTokenizer(bf.readLine());
         Money[i] = Integer.parseInt(st.nextToken());
      }
      
      int count = 0; // 동전의 개수
      
      for(int i=N-1; i>=0; i--) {
         count += K / Money[i]; // 몫이 0보다 크다는 의미는 동전을 사용했다는 의미이다
         K = K % Money[i]; // 나머지는 남은 금액(K원보다 Money[i]가 크면 나머지는 K원 그대로 이다)
         if(K==0) break;
      }
      System.out.println(count);
   }
}
