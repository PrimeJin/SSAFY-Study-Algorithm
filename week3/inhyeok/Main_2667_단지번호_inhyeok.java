package day0817;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;



public class b2667_단지번호 {
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[][] arr;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	//탐색 방향을 저장하기 위한 배열
	static boolean[][] visited;
	
	static int bfs(int x, int y) {
		Queue<Integer> qx=new LinkedList<Integer>();
		Queue<Integer> qy=new LinkedList<Integer>();
		//bfs 탐색을 위해 담을 queue x와 queue y
		qx.add(x);
		qy.add(y);
		//처음 들어온 숫자를 넣어준다.
		int ans=1;
		//처음 들어온 숫자는 반드시 1이기때문에 개수는 1부터 센다.
		visited[x][y]=true;
		//시작점을 방문했음을 처리해준다.
		while(!qx.isEmpty()) {//큐가 빌때까지 실행
			int tmpx=qx.poll();
			int tmpy=qy.poll();

			for(int i=0;i<4;i++) {
				if(arr[tmpx+dx[i]][tmpy+dy[i]]==1&visited[tmpx+dx[i]][tmpy+dy[i]]==false) {
					//4방위 탐색을 진행한다.
					qx.add(tmpx+dx[i]);
					qy.add(tmpy+dy[i]);
					//큐에 인접점들중 1이고 아직 방문안한 점을 추가한다.
					visited[tmpx+dx[i]][tmpy+dy[i]]=true;
					//큐에 넣었으니 방문했음을 표시해준다.
					ans+=1;
					//모여있는 아파트 수를 +1 해준다.
				}
			}
		}
		
		return ans;
		//단지개수를 반환한다.
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n+2][n+2];
		visited=new boolean[n+2][n+2];
		ArrayList<Integer> ans=new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++) {
			String str=br.readLine();
			for(int j=1;j<=n;j++) {
				arr[i][j]=(int)(str.charAt(j-1))-48;
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==1&visited[i][j]==false) {
					ans.add(bfs(i,j));
					//모든 점에 대해 bfs를 돌릴 필요는 없다. 
					//아파트가 있고, 아직 방문을 안한점에 대해 bfs를 돌린다.
					//하나의 1이 있어서 탐색을 시작하면, 붙어있는 아파트들은 전부 visited처리되기 때문에 bfs가 돌지 않는다.
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(ans.size()+"\n");
		Collections.sort(ans);
		for(int i=0;i<ans.size();i++) {
			sb.append(ans.get(i)+"\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}

}