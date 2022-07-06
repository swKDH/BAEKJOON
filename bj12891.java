package ù°��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12891 { // �����̵� ������ �˰��� ��� -> �ϳ��� �̵� : �׷��� �ð����⵵ O(n)
   static int currentcheck[];
   static int check[];  //��������
   static int count;
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int s = Integer.parseInt(st.nextToken());  // ���ڿ� �� ���� 
      int p = Integer.parseInt(st.nextToken());  // �κ� ���ڿ� ����
      int answer = 0;   // �������� �䱸�ϴ� ��
      check = new int[4];  // ex)2 0 0 1 ���� �������� ����ڰ� �������ִ� �� ����
      currentcheck = new int[4]; /* ���ڿ��� ���ڷ� �ɰ� A,C,G,T�� �ش��ϴ�
                                 ���� ������ 1�� �����ִ� ���� �����ϴ� �迭*/
      count = 0; // 4�� �Ǿ�� ����
      char[] c = new char[s]; // �迭 c�� s���̸�ŭ ���� ����.
      
      c = bf.readLine().toCharArray(); // ���۷� �о���� ���ڿ��� ���ڷ� �ٲ�
      st = new StringTokenizer(bf.readLine()); // enter �ѹ� �� ����
      for(int i=0;i<4;i++) {
         check[i] = Integer.parseInt(st.nextToken());
         if(check[i] == 0) { // 2 0 1 1 �� ��� 0 �� �ϳ� �ֱ� ������ count�� 1�� �������� �Ѵ�.
            count++; // 0 �������� 4���� 1���� ī��Ʈ ���ش�.
         }
      }
      for(int i=0;i<p;i++) { //�κ� ���ڿ��� �޴°�
         add(c[i]);
      }
      if(count == 4) answer++;
      
      for(int i=p;i<s;i++) { // �����̵� ������.
         int j= i-p;
         add(c[i]);
         sub(c[j]);
         if(count == 4) answer++;
      }
      System.out.println(answer);
   }

   private static void sub(char c) {
      // TODO Auto-generated method stub
      switch(c) {
      case 'A':
         if(currentcheck[0] == check[0]) count--;
         currentcheck[0]--;
         break;
      case 'C':
         if(currentcheck[1] == check[1]) count--;
         currentcheck[1]--;
         break;
      case 'G':
         if(currentcheck[2] == check[2]) count--;
         currentcheck[2]--;
         break;
      case 'T':
         if(currentcheck[3] == check[3]) count--;
         currentcheck[3]--;
         break;
      }
   }

   private static void add(char c) {
      // TODO Auto-generated method stub
      switch(c) {
      case 'A':
         currentcheck[0]++;
         if(currentcheck[0] == check[0]) count++;
         break;
      case 'C':
         currentcheck[1]++;
         if(currentcheck[1] == check[1]) count++;
         break;
      case 'G':
         currentcheck[2]++;
         if(currentcheck[2] == check[2]) count++;
         break;
      case 'T':
         currentcheck[3]++;
         if(currentcheck[3] == check[3]) count++;
         break;
      }
   }
}
