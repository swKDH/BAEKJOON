package 둘째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj13251 {
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int M = Integer.parseInt(st.nextToken()); // 조약돌의 색상
      st = new StringTokenizer(bf.readLine());
      int N[] = new int[M];
      for(int i=0; i<M;i++) N[i] = Integer.parseInt(st.nextToken()); // 각 색상에 대한 조약돌의 개수 
      int K = Integer.parseInt(bf.readLine()); // 꺼낼 조약돌의 개수
      int t = 0;
      double total = 0;
      for(int i=0; i<M; i++) t += N[i]; // 조약돌의 총 개수
      for(int i=0; i<M;i++) {
         if(N[i] >= K) {
            double prob = 1;
            for(int j=0; j<K; j++) {
               prob *= (N[i]-j);
               prob /= (t-j);
            }
            total += prob;
         }
      }
      System.out.println(total);
      
   }
}
