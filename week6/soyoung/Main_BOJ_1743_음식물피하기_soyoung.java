import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 음식물 피하기
 * 
 */

public class Main_BOJ_1743_음식물피하기_S1 {
	static int maxSize, curSize;
	static boolean[][] map, visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int H, W, K;
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[H][W];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = true;
		}
		
		//dfs
		visited = new boolean[H][W];
		maxSize = 1;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] && !visited[i][j]) {
					curSize = 1;
					visited[i][j] = true;
					dfs(i, j);
					
					maxSize = Math.max(curSize, maxSize);
				}
			}
		}
		
		System.out.println(maxSize);
	}
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int ny = r+dy[i];
			int nx = c+dx[i];
			if(ny>=0 && nx>=0 && ny < map.length && nx < map[0].length) {
				if(map[ny][nx] && !visited[ny][nx]) {
					curSize++;
					visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}
	}
	
}
