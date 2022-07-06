package ù°��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1874 {

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      StringBuilder sb = new StringBuilder(); // ����� ����� ���� 
      
      Stack<Integer> stack = new Stack<>();
      
      int N = Integer.parseInt(br.readLine()); // ù�� �Է� ���� 
      
      int start = 0;
      
      
      while (N-->0) { // N-->0 �̶� N--; �� N>0 �� ��ģ�Ŷ� ����  , N �� �ݺ� 
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