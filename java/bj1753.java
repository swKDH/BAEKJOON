import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1753 {

    static final int INF = 100000000;
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visit; // ���� �湮 ����

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine()); // �����

        list = new ArrayList[v + 1];  // ���� ���� ����

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()); // ����
            int next = Integer.parseInt(st.nextToken());  // ����
            int weight = Integer.parseInt(st.nextToken()); // ����ġ

            list[start].add(new Node(next, weight));
        }

        distance = new int[v + 1];  // �� �������� �ִܰŸ� ���� �迭
        Arrays.fill(distance, INF); // ������ for���� ����ؼ� �迭�� ���� �ʱ�ȭ �ؾ��ϴµ� �����ϰ� �ʱ�ȭ ����.
        							// ��� ������ 100000000���� �ϰ� �ִ� �Ÿ��϶� update�ϱ� ���� �ڵ�.
        visit = new boolean[v + 1]; // �� ���� �湮���� �迭

        dijkstra(k); // ���ͽ�Ʈ�� �˰��� ����

        for(int i=1; i<distance.length; i++){ // ���
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
        que.add(new Node(start, 0)); // �켱���� ť�� ���۳�� �ֱ�.
        distance[start] = 0; // �ִܰŸ� ���̺��� ������������� �� 0���� ����.

        while (!que.isEmpty()) { // �켱���� ť�� ��尡 �����ϸ� ��� �ݺ�

            Node current = que.poll();
            int currentNode = current.point;
            int currentWeight = current.value;

            if (!visit[currentNode]) { // �湮���� �ʾҴٸ�...
                for (int i = 0; i < list[currentNode].size(); i++) {
                    int nextNode = list[currentNode].get(i).point;
                    int nextWeight = list[currentNode].get(i).value;	

                    if (distance[nextNode] > currentWeight + nextWeight) {  
                    	// ���� ��带 ���ļ� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
                        distance[nextNode] = currentWeight + nextWeight;
                        que.add(new Node(nextNode, distance[nextNode])); // ���ŵ� �ִ� �Ÿ��� ť�� �־��ش�.
                    }
                }
            }
        }
    }


    public static class Node implements Comparable<Node>{ // �켱���� ť���� ���ı����� ������� comparable�� �����Ѵ�.
        int point; // ����
        int value; // ����ġ

        Node(int point, int value) {
            this.point = point;
            this.value = value;
        }
        //�ִܰŸ��� �������� �������� ����.
        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}
