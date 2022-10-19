import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1, 0};  //북 동 남 서
	static int[] dx = {0, 1, 0, -1};
	static int N;
	static int M;
	static int[][] map;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //세로크기
		M = Integer.parseInt(st.nextToken());  //가로크기
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		//맵 초기화
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 1;
		dfs(r,c,d);
		System.out.println(answer);
	}
	
	public static void dfs(int y, int x, int dir) {
		map[y][x] = -1;  //로봇 현재 위치 청소처리
		for(int i=0; i<4; i++) {
			dir = (dir+3)%4;  //왼쪽 방향부터 차례대로 탐색 진행
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			if(0<=ny&&ny<N && 0<=nx&&nx<M && map[ny][nx] == 0) {  //청소할 공간이 있으면 청소진행
				answer++;  //청소한 칸 개수 1증가
				dfs(ny, nx, dir);  //방향으로 이동해서 청소할 칸 탐색
				return;
			}
		}
		//더이상 청소할 공간이 없으면		
		int backDir = (dir+2)%4;  //바라보는 방향에서 한 칸 후진 세팅
		int backY = y + dy[backDir];
		int backX = x + dx[backDir];
		if(0<=backY&&backY<N && 0<=backX && backX<M && map[backY][backX]!=1) {  //후진할 수 있는 상황이면 후진
			dfs(backY, backX, dir);  //후진하고 청소할 칸 탐색 
		}
		
	}
}