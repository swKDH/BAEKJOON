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

			// 확인했던 용량이면 패스
			if (visited[temp[0]][temp[1]][temp[2]])
				continue;
			// 확인안했다면 체크하고
			visited[temp[0]][temp[1]][temp[2]] = true;

			// 만약 a물통이 비었다면 c물통에 담긴 물 양 답에 저장
			if (temp[0] == 0)
				ans.add(temp[2]);

			// a물통, b물통
			if (temp[0] + temp[1] > a) { // 합이 a보다 크면, a 다 채우고 나머지 b
				q.add(new int[] { a, temp[0] + temp[1] - a, temp[2] });
			} else { // 합이 a보다 작으면, 전부 a로 옮기기
				q.add(new int[] { temp[0] + temp[1], 0, temp[2] });
			}

			if (temp[0] + temp[1] > b) { // 합이 b보다 크면, b 다 채우고 나머지 a
				q.add(new int[] { temp[0] + temp[1] - b, b, temp[2] });
			} else { // 합이 b보다 작으면, 전부 b로 옮기기
				q.add(new int[] { 0, temp[0] + temp[1], temp[2] });
			}

			// a물통, c물통
			if (temp[0] + temp[2] > a) { // 합이 a보다 크면, a 다 채우고 나머지 c
				q.add(new int[] { a, temp[1], temp[0] + temp[2] - a });
			} else { // 합이 a보다 작으면, 전부 a로 옮기기
				q.add(new int[] { temp[0] + temp[2], temp[1], 0 });
			}

			if (temp[0] + temp[2] > c) { // 합이 c보다 크면, c 다 채우고 나머지 a
				q.add(new int[] { temp[0] + temp[2] - c, temp[1], c });
			} else { // 합이 c보다 작으면, 전부 c로 옮기기
				q.add(new int[] { 0, temp[1], temp[0] + temp[2] });
			}

			// b물통, c물통
			if (temp[1] + temp[2] > b) { // 합이 b보다 크면, b 다 채우고 나머지 c
				q.add(new int[] { temp[0], b, temp[1] + temp[2] - b });
			} else { // 합이 b보다 작으면, 전부 b로 옮기기
				q.add(new int[] { temp[0], temp[1] + temp[2], 0 });
			}

			if (temp[1] + temp[2] > c) { // 합이 c보다 크면, c 다 채우고 나머지 b
				q.add(new int[] { temp[0], temp[1] + temp[2] - c, c });
			} else { // 합이 c보다 작으면, 전부 c로 옮기기
				q.add(new int[] { temp[0], 0, temp[1] + temp[2] });
			}
		}

		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}
}