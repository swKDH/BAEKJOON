import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1068 {
    static int N, eraseT, root;
    static ArrayList<ArrayList<Integer>> tree;
    static int[] leaf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 트리의 노드의 개수 N
        StringTokenizer st = new StringTokenizer(br.readLine());
        eraseT = Integer.parseInt(br.readLine()); // 지울 노드의 번호

        leaf = new int[N]; // 리프 노드를 저장할 배열
        // 백준 제출시 주석 처리
//        @SuppressWarnings("unchecked")
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++)
            tree.add(new ArrayList<Integer>()); // 초기화
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1)
                root = i; // 트리의 루트
            else
                tree.get(parent).add(i); // 각 노드의 자식
        }

        for (int i = 0; i < N; i++) {
            // 지울 노드
            tree.get(i).removeIf(integer -> integer == eraseT);
        }

        if (eraseT != root)
            // 루트를 지울 경우 dfs 불필요
            DFS(root, -1);
        System.out.println(leaf[root]);
    }

    private static void DFS(int x, int parent) {
        if (tree.get(x).isEmpty())
            // 자식이 없으면 리프노드
            leaf[x] = 1;
        for (int y : tree.get(x)) {
            if (y == parent)
                // 부모노드는 이미 탐색 했기 때문에 넘기기
                continue;
            DFS(y, x);
            // 리프노드의 개수를 부모노드에 누적
            leaf[x] += leaf[y];
        }
    }
}
