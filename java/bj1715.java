import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위큐
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < n ; i++){
            int x = Integer.parseInt(bf.readLine());
            pq.add(x); // 한줄 씩 readline으로 받아주고 바로 큐에 삽입
                       //add 대신 offer을 사용해도 가능. offer가 더 빠름
        }

        int answer = 0;
        while(pq.size() > 1){ // 큐값이 하나밖에 없다면 계산을 할 수 없어서 >1 이라는 조건을 넣어줌.
            int a = pq.poll(); // 첫번째 값
            int b = pq.poll(); // 두번째 값

            answer += a+b; // 값을 두개 더한것
            pq.add(a+b); // 두개 더한 값을 다시 큐에 삽입
        }
        
        System.out.println(answer);
    }

}
