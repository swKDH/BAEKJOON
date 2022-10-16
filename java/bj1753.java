import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1753 {

    static final int INF = 100000000;
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visit; // 정점 방문 여부

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine()); // 출발점

        list = new ArrayList[v + 1];  // 간선 정보 저장

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()); // 시작
            int next = Integer.parseInt(st.nextToken());  // 도착
            int weight = Integer.parseInt(st.nextToken()); // 가중치

            list[start].add(new Node(next, weight));
        }

        distance = new int[v + 1];  // 각 정점까지 최단거리 저장 배열
        Arrays.fill(distance, INF); // 원래는 for문을 사용해서 배열의 값을 초기화 해야하는데 간편하게 초기화 가능.
        							// 모든 정점을 100000000으로 하고 최단 거리일때 update하기 위한 코드.
        visit = new boolean[v + 1]; // 각 정점 방문여부 배열

        dijkstra(k); // 다익스트라 알고리즘 실행

        for(int i=1; i<distance.length; i++){ // 출력
            if(distance[i] >= INF){
                bw.append("INF\n");
            }else{
                bw.append(distance[i]+"\n");
            }
        }
        bw.flush();
        bw.close();

    }

    public static void dijkstra(int start) {

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0)); // 우선순위 큐에 시작노드 넣기.
        distance[start] = 0; // 최단거리 테이블의 시작지점노드을 값 0으로 갱신.

        while (!que.isEmpty()) { // 우선순위 큐에 노드가 존재하면 계속 반복

            Node current = que.poll();
            int currentNode = current.point;
            int currentWeight = current.value;

            if (!visit[currentNode]) { // 방문하지 않았다면...
                for (int i = 0; i < list[currentNode].size(); i++) {
                    int nextNode = list[currentNode].get(i).point;
                    int nextWeight = list[currentNode].get(i).value;	

                    if (distance[nextNode] > currentWeight + nextWeight) {  
                    	// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
                        distance[nextNode] = currentWeight + nextWeight;
                        que.add(new Node(nextNode, distance[nextNode])); // 갱신된 최단 거리를 큐에 넣어준다.
                    }
                }
            }
        }
    }


    public static class Node implements Comparable<Node>{ // 우선순위 큐에서 정렬기준을 잡기위해 comparable을 구현한다.
        int point; // 정점
        int value; // 가중치

        Node(int point, int value) {
            this.point = point;
            this.value = value;
        }
        //최단거리를 기준으로 오름차순 정렬.
        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}
