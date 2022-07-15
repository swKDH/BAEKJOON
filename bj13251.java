package ��°��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj13251 {
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int M = Integer.parseInt(st.nextToken()); // ���൹�� ����
      st = new StringTokenizer(bf.readLine());
      int N[] = new int[M];
      for(int i=0; i<M;i++) N[i] = Integer.parseInt(st.nextToken()); // �� ���� ���� ���൹�� ���� 
      int K = Integer.parseInt(bf.readLine()); // ���� ���൹�� ����
      int t = 0;
      double total = 0;
      for(int i=0; i<M; i++) t += N[i]; // ���൹�� �� ����
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
