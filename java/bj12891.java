package 첫째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12891 { // 슬라이딩 윈도우 알고리즘 사용 -> 하나씩 이동 : 그래서 시간복잡도 O(n)
   static int currentcheck[];
   static int check[];  //전역변수
   static int count;
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int s = Integer.parseInt(st.nextToken());  // 문자열 총 길이 
      int p = Integer.parseInt(st.nextToken());  // 부분 문자열 길이
      int answer = 0;   // 문제에서 요구하는 답
      check = new int[4];  // ex)2 0 0 1 같은 문제에서 사용자가 지정해주는 값 저장
      currentcheck = new int[4]; /* 문자열을 문자로 쪼개 A,C,G,T에 해당하는
                                 값이 있으면 1씩 더해주는 값을 저장하는 배열*/
      count = 0; // 4가 되어야 만족
      char[] c = new char[s]; // 배열 c를 s길이만큼 공간 생성.
      
      c = bf.readLine().toCharArray(); // 버퍼로 읽어들인 문자열을 문자로 바꿈
      st = new StringTokenizer(bf.readLine()); // enter 한번 더 가능
      for(int i=0;i<4;i++) {
         check[i] = Integer.parseInt(st.nextToken());
         if(check[i] == 0) { // 2 0 1 1 의 경우 0 이 하나 있기 때문에 count를 1로 만들어줘야 한다.
            count++; // 0 이있으면 4개중 1개를 카운트 해준다.
         }
      }
      for(int i=0;i<p;i++) { //부분 문자열을 받는것
         add(c[i]);
      }
      if(count == 4) answer++;
      
      for(int i=p;i<s;i++) { // 슬라이딩 윈도우.
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
