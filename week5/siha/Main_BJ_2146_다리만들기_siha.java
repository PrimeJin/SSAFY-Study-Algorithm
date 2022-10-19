import java.io.*;
import java.util.*;

public class Main_BJ_2146_다리만들기_siha {
	
	static int N, lan_num;
	static int[][] board;
	static int[][] land;
	static int[][] disBoard;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int minRes = Integer.MAX_VALUE;
	
	static class Pos{
		
		int x, y;

		public Pos(int x, int y) {

			this.x = x;
			this.y = y;
		}			
		
	}//end Pos
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		disBoard = new int[N][N];
		land = new int[N][N];
		visited = new boolean[N][N];
		
		
		// 0 : 바다, 1 : 육지 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		lan_num = 1;
		
		//섬 번호 매기기
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && board[i][j] != 0) {
					bfs(i, j);	
					lan_num += 1;
				}
			}
		}
		
		
		
		
		
		//각 섬을 돌면서 최단거리 찾기 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(land[i][j] != 0) {
					findDis(i, j, land[i][j], visited);
				}
			}
		}	
		
		
		System.out.println(minRes);
		
		
	}//main





	private static void bfs(int x, int y) {
		
		Queue<Pos> queue = new LinkedList<>();
		
		queue.add(new Pos(x, y));
		land[x][y] = lan_num;
		
		int nx, ny;
		
		while(!queue.isEmpty()) {
			
			Pos now = queue.poll();
			visited[now.x][now.y] = true;
			
			
			for(int i=0;i<4;i++) {
				
				nx = now.x + dx[i];
				ny = now.y + dy[i];
			
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					if(board[nx][ny] == 1) {
						land[nx][ny] = lan_num;
						visited[nx][ny] = true;
						queue.add(new Pos(nx, ny));						
					}
				}
				
				
			}
		}

	
	}//end bfs
	
	
	
	private static void findDis(int x, int y, int lanNum, boolean[][] visited) {		
		
		Queue<Pos> queue = new LinkedList<>();

		visited = new boolean[N][N];
		disBoard = new int[N][N];
		queue.add(new Pos(x, y));

		int nx, ny;
		
		all: while(!queue.isEmpty()) {
			
			Pos now = queue.poll();
			visited[now.x][now.y] = true;			
			
			for(int i=0;i<4;i++) {
				
				nx = now.x + dx[i];
				ny = now.y + dy[i];
			
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] ) {
					if(land[nx][ny] != lanNum && land[nx][ny] == 0) {
						disBoard[nx][ny] = disBoard[now.x][now.y]+1; 
						visited[nx][ny] = true;
						queue.add(new Pos(nx, ny));			
					}
					//다른 섬을 만나면 종료 
					else if(land[nx][ny] != lanNum && land[nx][ny] != 0){
						
						int ex = nx;
						int ey = ny;
						
						for(int j=0;j<4;j++) {
							
							nx = ex + dx[j];
							ny = ey + dy[j];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N && disBoard[nx][ny]!=0) {
								minRes = Math.min(minRes, disBoard[nx][ny]);
							}
							
						}
						
						break all;
					}
				}
				
			}
		}
		
		
	}//end findDis

}