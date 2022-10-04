package study1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1743_음식물피하기 {
	static int n,m,k;
	//가로 세로 음식물 쓰레기 개수
	static int[][] arr;
	static boolean[][] visited;
	static int max=0;
	//bfs 돌리기위한 방문 배열, 음식물 배열
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int check=0;
	
	public static void dfs(int r, int c) {
		//재귀함수안에 숫자넣는법 기억이 안남 
		visited[r][c]=true;
		if(r==0||c==0||r==n+1||c==m+1) {
			return;
		}
		else if(arr[r][c]==0){
			return;
		}
		else {
			for(int i=0;i<4;i++) {
				if(!visited[r+dx[i]][c+dy[i]]&arr[r+dx[i]][c+dy[i]]==1) {
					check+=1;
					dfs(r+dx[i],c+dy[i]);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		arr=new int[n+2][m+2];
		visited=new boolean[n+2][m+2];
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a][b]=1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(!visited[i][j]) {
					check=0;
					dfs(i,j);
					if(check>max) {
						max=check;
					}
				}
			}
		}
		
		System.out.println(max+1);
		
	}
}
