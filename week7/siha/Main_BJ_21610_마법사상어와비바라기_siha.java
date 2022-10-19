package day1019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_21610_마법사상어와비바라기 {
	
	static int N,M;
	static int[][] board;
//	static int[][] cloud;
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };  //좌부터 시작
	static int[] dy = {-1, -1,  0,  1, 1, 1, 0, -1};
	static int d, s;
	static List<Pos> cloudList;
	static int[][] delBoard;
	
	static List<Pos> plus;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
//		cloud = new int[N][N];
		plus = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		cloudList = new ArrayList<>();
		delBoard = new int[N][N];
		
		cloudList.add(new Pos(N-1,0));
		cloudList.add(new Pos(N-1,1));
		cloudList.add(new Pos(N-2,0));
		cloudList.add(new Pos(N-2,1));
		
		//비바라기 시전
//		cloud[N-1][0] = 1;
//		cloud[N-1][1] = 1;
//		cloud[N-2][0] = 1;
//		cloud[N-2][1] = 1;
		
		
		
	
		for(int tc=0;tc<M;tc++) {
			
//			System.out.println((tc+1) + "분");
			st = new StringTokenizer(br.readLine());
		
			d = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
//			System.out.println("d, s : " + d + " " + s);
			
			delBoard = new int[N][N];
			
			//1. 구름 이동 및 바구니 물양 증가
			
			
			moveCloud();
//			System.out.println("이동 후 구름위치");
			for(int i=0;i<cloudList.size();i++) {
				Pos c = cloudList.get(i);
//				System.out.println(c.x + " " + c.y);
			}
			
//			System.out.println("이동 후");
//			for(int[] a : board) {
//				System.out.println(Arrays.toString(a));
//			}
			
			//3. 구름 사라짐
			delCloud();
			
			//4. 물이 증가한 칸에 물복사 버그 시전
			copyWater();
//			System.out.println("복사 후");
//			for(int[] a : board) {
//				System.out.println(Arrays.toString(a));
//			}
			
			//5. 저장된 물의 양이 2이상이면 구름이 생기고 물양 -2...이때 구름칸은 3에서 사라졌던 칸이아님
			makeCloud();
//			System.out.println("물양 증가");
//			for(int[] a : board) {
//				System.out.println(Arrays.toString(a));
//			}
			
			System.out.println("구름위치");
			for(int i=0;i<cloudList.size();i++) {
				Pos c = cloudList.get(i);
				System.out.println(c.x + " " + c.y);
			}
			
			System.out.println();
		
			
			
		}
			
		int res = 0;
			
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] != 0) {
					res += board[i][j];
				}
			}
		}
		
		
		System.out.println(res);
		
	}//main

	
	
	private static void makeCloud() {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] >= 2) {
					if(delBoard[i][j] != 1) {
						board[i][j] -= 2;
						cloudList.add(new Pos(i,j));					
					}
				}
			}
		}
		
	}



	private static void copyWater() {
		
//		int[][] tmp = new int[N][N];
		
		for(int i=0;i<plus.size();i++) {
			
			Pos p = plus.get(i);
			int cnt = 0;
			
			int nx, ny;
			for(int j=1;j<=7;j+=2) {
				nx = p.x + dx[j];
				ny = p.y + dy[j];
				
				//범위안에 있으면
				if(!OOR(nx,ny) && board[nx][ny] >= 1) {
					cnt += 1;
				}
								
			}
			
			board[p.x][p.y] += cnt; 
			
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				board[i][j] += tmp[i][j];
//			}
//		}
		
	}

	


	private static void delCloud() {
		
		for(int i=0;i<cloudList.size();i++) {
			Pos c = cloudList.get(i);
			delBoard[c.x][c.y] = 1; 
		}
		
		System.out.println("구름있던칸");
		for(int[] a:delBoard) {
			System.out.println(Arrays.toString(a));
		}
		
		cloudList.clear();
	
	}

	

	private static void moveCloud() {
		
//		int[][] tmp = new int[N][N];
		
		for(int i=0;i<cloudList.size();i++) {
			Pos c = cloudList.get(i);			
			int nx = c.x;
			int ny = c.y;
			
			for(int j=0;j<s;j++) {
				nx = nx + dx[d];
				ny = ny + dy[d];			
			
				if(nx < 0) {
					nx = N-1;
				}
				if(nx >= N) {
					nx = 0;
				}
				if(ny < 0) {
					ny = N-1;
				}
				if(ny >= N) {
					ny = 0;
				}
				
			}
			
//			cloud[c.x][c.y] = 0;
//			cloud[nx][ny] = 1;
			
			board[nx][ny] += 1;
			plus.add(new Pos(nx, ny));
			
			c.x = nx;
			c.y = ny;
			
//			for(int[] a :tmp) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
		}
		
	}



	private static boolean OOR(int x, int y) {
		//범위를 벗어나면 true 벗어나지 않으면 false
		return !(x >=0 && x < N && y >=0 && y < N);
		
	}
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}//end class
