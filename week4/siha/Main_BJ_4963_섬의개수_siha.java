import java.io.*;
import java.util.*;

public class Main_BJ_4963_섬의개수_siha {
	
	static int W, H, cnt;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, 1,  0, 0, -1, -1,  1, 1};
	static int[] dy = { 0, 0, -1, 1, -1,  1, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0)	break;
			
			board = new int[H][W];
			visited = new boolean[H][W];
			cnt = 0;
			
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
					
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(!visited[i][j] && board[i][j] != 0) {
						dfs(i, j);
						cnt+=1;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
	}//main

	
	
	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		int nx, ny;
		
		for(int i=0;i<8;i++) {
			
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny] != 0) {
				if(!visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
			else  	continue;
			
		}
		
		
		
	}//end dfs
	
}//end class
