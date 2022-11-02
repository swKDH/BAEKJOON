import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2251 {
	static int a, b, c;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		visited = new boolean[a + 1][b + 1][c + 1];

		ArrayList<Integer> ans = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0, c });

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			// Ȯ���ߴ� �뷮�̸� �н�
			if (visited[temp[0]][temp[1]][temp[2]])
				continue;
			// Ȯ�ξ��ߴٸ� üũ�ϰ�
			visited[temp[0]][temp[1]][temp[2]] = true;

			// ���� a������ ����ٸ� c���뿡 ��� �� �� �信 ����
			if (temp[0] == 0)
				ans.add(temp[2]);

			// a����, b����
			if (temp[0] + temp[1] > a) { // ���� a���� ũ��, a �� ä��� ������ b
				q.add(new int[] { a, temp[0] + temp[1] - a, temp[2] });
			} else { // ���� a���� ������, ���� a�� �ű��
				q.add(new int[] { temp[0] + temp[1], 0, temp[2] });
			}

			if (temp[0] + temp[1] > b) { // ���� b���� ũ��, b �� ä��� ������ a
				q.add(new int[] { temp[0] + temp[1] - b, b, temp[2] });
			} else { // ���� b���� ������, ���� b�� �ű��
				q.add(new int[] { 0, temp[0] + temp[1], temp[2] });
			}

			// a����, c����
			if (temp[0] + temp[2] > a) { // ���� a���� ũ��, a �� ä��� ������ c
				q.add(new int[] { a, temp[1], temp[0] + temp[2] - a });
			} else { // ���� a���� ������, ���� a�� �ű��
				q.add(new int[] { temp[0] + temp[2], temp[1], 0 });
			}

			if (temp[0] + temp[2] > c) { // ���� c���� ũ��, c �� ä��� ������ a
				q.add(new int[] { temp[0] + temp[2] - c, temp[1], c });
			} else { // ���� c���� ������, ���� c�� �ű��
				q.add(new int[] { 0, temp[1], temp[0] + temp[2] });
			}

			// b����, c����
			if (temp[1] + temp[2] > b) { // ���� b���� ũ��, b �� ä��� ������ c
				q.add(new int[] { temp[0], b, temp[1] + temp[2] - b });
			} else { // ���� b���� ������, ���� b�� �ű��
				q.add(new int[] { temp[0], temp[1] + temp[2], 0 });
			}

			if (temp[1] + temp[2] > c) { // ���� c���� ũ��, c �� ä��� ������ b
				q.add(new int[] { temp[0], temp[1] + temp[2] - c, c });
			} else { // ���� c���� ������, ���� c�� �ű��
				q.add(new int[] { temp[0], 0, temp[1] + temp[2] });
			}
		}

		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}
}