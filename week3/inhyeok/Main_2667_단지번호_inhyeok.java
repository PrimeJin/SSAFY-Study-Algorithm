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
	static int[] dx= {0,0,1,0,-1};
	static int[] dy= {0,1,0,-1,0};
	static boolean[][] visited;
	
	static int bfs(int x, int y) {
		Queue<Integer> qx=new LinkedList<Integer>();
		Queue<Integer> qy=new LinkedList<Integer>();
		qx.add(x);
		qy.add(y);
		int ans=0;
		while(!qx.isEmpty()) {
			int tmpx=qx.poll();
			int tmpy=qy.poll();
			for(int i=0;i<5;i++) {
				if(arr[tmpx+dx[i]][tmpy+dy[i]]==1&visited[tmpx+dx[i]][tmpy+dy[i]]==false) {
					qx.add(tmpx+dx[i]);
					qy.add(tmpy+dy[i]);
					visited[tmpx+dx[i]][tmpy+dy[i]]=true;
					ans+=1;
				}
			}
		}
		
		return ans;
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