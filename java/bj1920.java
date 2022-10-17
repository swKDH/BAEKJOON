import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920 {
    public static void main(String[] args) throws Exception{
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(a.readLine());
        StringTokenizer Nst = new StringTokenizer(a.readLine());
        int arr1[] = new int[N];

        for(int i=0;i<N;i++){
            arr1[i] = Integer.parseInt(Nst.nextToken());
        }

        Arrays.sort(arr1);
        int M = Integer.parseInt(a.readLine());
        StringTokenizer Mst = new StringTokenizer(a.readLine());

        for(int k=0;k<M;k++){
            boolean find = false;
            int target = Integer.parseInt(Mst.nextToken());
            int start = 0;
            int end = arr1.length-1; 
            while(start <= end){
                int mid = (start + end)/2;
                 if(arr1[mid] > target){
                    end = mid-1;
                 }
                else if(target > arr1[mid]){
                    start = mid+1;
                }
                else{
                    find = true;
                    break;
                }
            }
            if(find){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}


