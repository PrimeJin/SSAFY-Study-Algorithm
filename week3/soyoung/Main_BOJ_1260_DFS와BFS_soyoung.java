import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS_soyoung {
	static int N, edges, start;
	static int map[][];
	static boolean visited[];

	public static void bfs(int start) {
		// bfs: Queue 이용
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		// bfs
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (visited[cur])
				continue; // 이미 방문했다면 넘어가기
			visited[cur] = true;
			System.out.print(cur + " ");
			for (int i = 1; i <= N; i++) {
				if (map[cur][i] == 1 && visited[i] == false) {
					q.add(i);
				}
			}
		}
		System.out.println();

	}

	public static void dfs(int start) {
		// dfs: Stack 이용
		Stack<Integer> st = new Stack<>();
		st.add(start);
		// dfs
		while (!st.isEmpty()) {
			int cur = st.pop();
			if (visited[cur])
				continue;
			visited[cur] = true;
			System.out.print(cur + " ");
			for (int i = N; i >= 1; i--) { // 정점번호가 작은 것 먼저 방문하기 위해
				if (map[cur][i] == 1 && visited[i] == false) {
					st.add(i);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		edges = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		for (int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1; // connection
			map[b][a] = 1;
		}

		visited = new boolean[N + 1];
		dfs(start);
		visited = new boolean[N + 1];
		bfs(start);
	}
}