import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS_woojin {
	static int N;
	static int M;
	static int V;
	static boolean[][] connect;
	static boolean[] isChecked;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //정점 개수
		M = Integer.parseInt(st.nextToken());  //간선 개수
		V = Integer.parseInt(st.nextToken());  //탐색시작할 정점 번호
		
		connect = new boolean[N+1][N+1];
		isChecked = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			connect[a][b] = true;
			connect[b][a] = true;
		}
		dfs(V);
		sb.append("\n");
		isChecked = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}
	
	public static void dfs(int n) {
		sb.append(n + " ");
		isChecked[n] = true;
		for(int i=1; i<=N; i++) {
			if(connect[n][i] && !isChecked[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		isChecked[n] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " ");
			for(int i=1; i<=N; i++) {
				if(connect[cur][i] && !isChecked[i]) {
					queue.offer(i);
					isChecked[i] = true;
				}
			}
		}
	}
}
