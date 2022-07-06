package Ã¹Â°ÁÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11659 {
public static void main(String[] args) throws IOException {
   BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st=new StringTokenizer(bf.readLine());
   
   int N =Integer.parseInt(st.nextToken()); 
   int M =Integer.parseInt(st.nextToken()); 
   int arr[] = new int[N];
   int sum[] = new int[N+1];
   
    st=new StringTokenizer(bf.readLine());
   

   for(int i=0; i<N; i++) {
      arr[i]=Integer.parseInt(st.nextToken());
      }
   
   sum[1]=arr[0];
   
   for(int i=2;i<N+1;i++) {
         sum[i]=sum[i-1]+arr[i-1];
   }
   for(int i=0; i<M; i++) {
      st=new StringTokenizer(bf.readLine());
      int s=Integer.parseInt(st.nextToken());
      int e=Integer.parseInt(st.nextToken());
      System.out.println(sum[e]-sum[s-1]);
   }
   
}
}
