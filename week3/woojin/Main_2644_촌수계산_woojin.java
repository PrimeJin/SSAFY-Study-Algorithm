import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산_woojin {
	static boolean[][] connect;
	static boolean[] isChecked;
	static int N;
	static int start;
	static int end;
	static int[] relation;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  //전체 사람 수
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		connect = new boolean[N+1][N+1];
		isChecked = new boolean[N+1];
		relation = new int[N+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());  //부모  (각 사람의 부모는 최대 한명)
			int y = Integer.parseInt(st.nextToken());  //자식
			connect[x][y] = true;
			connect[y][x] = true;
		}
		
		bfs(start, end);
		System.out.println(relation[end] == 0 ? -1: relation[end]);
	}
	
	public static void bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);  //시작하는 사람 넣기
		isChecked[start] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == end) return;  //찾으려는 사람까지 방문하면 종료
			
			for(int i=1; i<=N; i++) {
				if(connect[cur][i] && !isChecked[i]) {
					queue.offer(i);
					isChecked[i] = true;
					relation[i] = relation[cur]+1;
				}
			}
		}
	}
}
