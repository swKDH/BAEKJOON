package 첫째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1874 {

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      StringBuilder sb = new StringBuilder(); // 출력할 결과를 저장 
      
      Stack<Integer> stack = new Stack<>();
      
      int N = Integer.parseInt(br.readLine()); // 첫줄 입력 받음 
      
      int start = 0;
      
      
      while (N-->0) { // N-->0 이란 N--; 와 N>0 을 합친거랑 같음  , N 번 반복 
         int value = Integer.parseInt(br.readLine());
         
         if(value > start) {
            for (int i= start +1; i<=value; i++) {
               stack.push(i);
               sb.append('+').append('\n');
            }
            start = value;
         }
         
         else if (stack.peek() != value) {
            System.out.println("NO");
            return;
         }
         stack.pop();
         sb.append('-').append('\n');
      }
      System.out.println(sb);
   }

}