import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int y;
		int x;
		
		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int[] dy = {0,1,0,-1};  //우 하 좌 상
	static int[] dx = {1,0,-1,0};
	static int[][] map;
	static boolean[][] visited;
	static int N, M, K;
	static int sum;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //세로 길이
		M = Integer.parseInt(st.nextToken());  //가로 길이
		K = Integer.parseInt(st.nextToken());  //음식물 쓰레기 개수
		
		map = new int[N][M];
		visited = new boolean[N][M];
		//쓰레기 위치 초기화
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r-1][c-1] = 1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum = 0;
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
				}
				answer = Math.max(answer, sum);
			}
		}
		
		System.out.println(answer);
	}
	
	public static void bfs(int y, int x) {
		Queue<Position> queue = new ArrayDeque<>();
		queue.offer(new Position(y, x));
		visited[y][x] = true;  //방문처리
		sum++;  //쓰레기 개수+1
		
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0<=ny&&ny<N && 0<=nx&&nx<M) {
					if(map[ny][nx]!=0 && !visited[ny][nx]) {  //주어진 범위 내 체크
						visited[ny][nx] = true;  //방문처리
						sum++;  //쓰레기 개수 + 1
						queue.offer(new Position(ny, nx));
					}
				}
			}
			
		}
	}
}
