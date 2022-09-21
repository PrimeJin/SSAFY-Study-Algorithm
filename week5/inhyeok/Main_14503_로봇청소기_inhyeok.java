package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 
1 현재 위치를 청소한다.
2 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
	1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
	2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 * */

public class b14503_로봇청소기 {
	static int d;
	static int r,c;
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int exit=0;
	
	public static void nextD(){
		//0북 1동 2남 3서
		if(d==0) {
			d=3;
		}
		else {
			d=d-1;
		}
	}
	
	public static boolean checkLeft() {
		if(d==0) {
			if(map[r][c-1]==0&!visit[r][c-1]) {
				return true;
			}
		}
		else if(d==1) {
			if(map[r-1][c]==0&!visit[r-1][c]) {
				return true;
			}
		}
		else if(d==2) {
			if(map[r][c+1]==0&!visit[r][c+1]) {
				return true;
			}
		}
		else if(d==3) {
			if(map[r+1][c]==0&!visit[r+1][c]) {
				return true;
			}
		}
		return false;
		
	}
	
	public static void goFront(){
		//0북 1동 2남 3서
		if(d==0) {
			if(map[r][c-1]==0) {
				visit[r][c]=true;
				c=c-1;
			}
		}
		else if(d==1) {
			if(map[r-1][c]==0) {
				visit[r][c]=true;
				r=r-1;
			}
		}
		else if(d==2) {
			if(map[r][c+1]==0) {
				visit[r][c]=true;
				c=c+1;
			}
		}
		else if(d==3) {
			if(map[r+1][c]==0) {
				visit[r][c]=true;
				r=r+1;
			}
		}
	}
	
	public static void goBack(){
		//0북 1동 2남 3서
		if(d==0) {
			if(map[r+1][c]==0) {
				visit[r][c]=true;
				r=r+1;
			}
			else {
				visit[r][c]=true;
				exit=1;
			}
		}
		else if(d==1){
			if(map[r][c-1]==0) {
				visit[r][c]=true;
				c=c-1;
			}
			else {
				visit[r][c]=true;
				exit=1;
			}
		}
		else if(d==2){
			if(map[r-1][c]==0) {
				visit[r][c]=true;
				r=r-1;
			}
			else {
				visit[r][c]=true;
				exit=1;
			}
		}
		else if(d==3) {
			if(map[r][c+1]==0) {
				visit[r][c]=true;
				c=c+1;
			}
			else {
				visit[r][c]=true;
				exit=1;
			}
		}
	}
	
	
	public static void check() {
		
		//없으면 왼쪽방향으로 돔
			//1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
			if(checkLeft()) {
				goFront();
				nextD();
			}
			else if((visit[r][c-1]||map[r][c-1]==1)&(visit[r][c+1]||map[r][c+1]==1)&(visit[r+1][c]||map[r+1][c]==1)&(visit[r-1][c]||map[r-1][c]==1))
			{//네방향 모두 청소 되었을 경우
			//뒤에가 벽이면 종료
				//아니면 뒤로 후진
				goBack();
			}
			else {
				visit[r][c]=true;
				nextD();
			}
//			if(visit[r][c].contains(d)) {
//				exit=1;
//			}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		
		visit=new boolean[n][m];
		//이미 지났던 장소면 체크해둔다. 지났던 장소에 같은 방향으로 도착한다면 정지시킨다. 
		
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(exit==0) {
			check();
		}
		
		int cnt=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visit[i][j]) {
					cnt+=1;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
