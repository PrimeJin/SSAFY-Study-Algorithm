import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색 {
	
	static int N, M, cnt;
	static char[][] board;
	static int[][] res;
	static boolean[][] visited;
	static int[] dx = {1, -1,  0,  0};	//상하좌우
	static int[] dy = {0,  0, -1,  1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[N][M];
		res = new int[N][M];
		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		move(0, 0);
		System.out.println(res[N-1][M-1] + 1);
		
		
	}
	
	private static void move(int x, int y) {
		
//		if(x == N-1 && y == M-1) {
////			cnt+=1;
//			return;
//		}
		
		int nx, ny;
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != '0' && !visited[nx][ny]) {
				res[nx][ny] = res[x][y] + (board[nx][ny] - '0');
//				cnt += 1;
				move(nx ,ny);			
				visited[nx][ny] = false;
				
			}
		
		}
		
	}
	
	
}
