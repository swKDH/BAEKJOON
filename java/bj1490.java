import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1490 {
    public static void main(String[] args) throws Exception{
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(a.readLine());
        int M = Integer.parseInt(a.readLine());
        int arr[] = new int[N];

        StringTokenizer b = new StringTokenizer(a.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(b.nextToken());
        }
        Arrays.sort(arr);
        int count=0;
        int start=0; //arr[0]
        int end=N-1; // arr[n-1]

        while(start<end){ 
            if(arr[start]+arr[end]< M)start++;
            else if(arr[start]+arr[end]> M)end--;
            else{
                count++;
                start++;
                end--;
            }
        }


        System.out.println(count);
    }
}

