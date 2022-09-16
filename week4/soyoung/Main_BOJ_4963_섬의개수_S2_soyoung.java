package ps0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4963_섬의개수_S2 {
	
	public static int dy[] = {-1, 1, 0, 0, -1,-1, 1, 1};
	public static int dx[] = { 0, 0,-1, 1, -1, 1,-1, 1};
	static int width, height;
	static int[][] map;
	static boolean[][] visited;
	static int islands = 0;
	
	
	public static void dfs(int r, int c) {
//		System.out.println("dfs("+r+", "+c+")");
		
		//사방 중에 갈 수 있으면 가기
		for (int i = 0; i < 8; i++) {
			int ny = r+dy[i];
			int nx = c+dx[i];
			
			//OutOfIndexBounds
			if(ny<0 || nx<0 || ny>=height || nx>=width) {
				continue;
			}
			
//			System.out.println("map[][] = "+map[ny][nx]);
			if(map[ny][nx]==1 && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		
		while(true) {
			st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			//종료조건
			if(width==0 && height==0) return;
			
			//map 초기화
			map = new int[height][width];
			visited = new boolean[height][width];
			islands = 0;
			for (int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			//섬 개수 구하기(dfs)
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
//						System.out.println("hi");
						islands++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}
			
			//출력
			System.out.println(islands);
		}
	}
}
