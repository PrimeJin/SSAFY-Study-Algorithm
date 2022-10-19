import java.io.*;
import java.util.*;

public class Main_BJ_1743_음식물피하기_siha {
	
	static int N, M, K, cnt;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int maxRes = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			board[n-1][m-1] = 1;
		}
		
//		for(int[] a : board) {
//			System.out.println(Arrays.toString(a));
//		}
		
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j] && board[i][j] == 1) {
					cnt = 1;
					visited[i][j] = true;
					dfs(i, j);
					maxRes = Math.max(maxRes, cnt);
				}
			}
		}
		
		System.out.println(maxRes);
		
	}//main


	
	
	
	private static void dfs(int x, int y) {
		
		int nx, ny;
		
		for(int i=0;i<4;i++) {
			
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >=0 && ny < M && !visited[nx][ny] && board[nx][ny] == 1) {
				visited[nx][ny] = true;
				cnt+=1;
				dfs(nx, ny);
				
			}
			
		}
		
		return;
		
	}
	
	
	
	
	
}//end class
