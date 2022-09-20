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
        N = Integer.parseInt(br.readLine()); // Ʈ���� ����� ���� N
        StringTokenizer st = new StringTokenizer(br.readLine());
        eraseT = Integer.parseInt(br.readLine()); // ���� ����� ��ȣ

        leaf = new int[N]; // ���� ��带 ������ �迭
        // ���� ����� �ּ� ó��
//        @SuppressWarnings("unchecked")
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++)
            tree.add(new ArrayList<Integer>()); // �ʱ�ȭ
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1)
                root = i; // Ʈ���� ��Ʈ
            else
                tree.get(parent).add(i); // �� ����� �ڽ�
        }

        for (int i = 0; i < N; i++) {
            // ���� ���
            tree.get(i).removeIf(integer -> integer == eraseT);
        }

        if (eraseT != root)
            // ��Ʈ�� ���� ��� dfs ���ʿ�
            DFS(root, -1);
        System.out.println(leaf[root]);
    }

    private static void DFS(int x, int parent) {
        if (tree.get(x).isEmpty())
            // �ڽ��� ������ �������
            leaf[x] = 1;
        for (int y : tree.get(x)) {
            if (y == parent)
                // �θ���� �̹� Ž�� �߱� ������ �ѱ��
                continue;
            DFS(y, x);
            // ��������� ������ �θ��忡 ����
            leaf[x] += leaf[y];
        }
    }
}