import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색_BFS_siha {
	
	static int N, M;
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
		
		
	}//main 
	
	
	//현재 좌표를 큐에 저장할 때 사용 
	static class Now{	
		
		int x;
		int y;
		
		public Now(int x, int y) {

			this.x = x;
			this.y = y;
		}
		
	}
	
	
	
	private static void move(int x, int y) {
		
		
		Queue<Now> queue = new LinkedList<>();
		
		int nx, ny;
		queue.add(new Now(x, y));	

		
		while(!queue.isEmpty()) {			//큐에 원소가 없을때까지 == 모든 갈수있는 배열을 다 돌때까지 계속 탐색	
			
			Now now = queue.poll();			//큐에서 원소를 꺼냄(앞)
			
			for(int i=0;i<4;i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != '0' && !visited[nx][ny]) {
					queue.add(new Now(nx, ny));				//갈수있다면 큐에 삽입(뒤)
					res[nx][ny] = res[now.x][now.y] + 1;	//인접한 칸으로만 이동가능하므로 1 증가
					visited[nx][ny] = true; 				//방문처리
				}			
			}
			
		}//end while
		
	}//end move()
	
	
	
	
}//end class