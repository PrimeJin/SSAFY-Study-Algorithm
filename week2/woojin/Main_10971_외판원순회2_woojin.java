import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	static int[][] W;
	static boolean[] colCheck; 
	static int N;  //도시 수
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = new int[N+1][N+1];
		colCheck = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				W[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i<=N;i++) {
			colCheck[i]=true;
			dfs(i,i,0,0);
			colCheck[i]=false;
		}
		
		System.out.println(min);		
	}
	public static void dfs(int row, int col, int cost, int count) {
		if(count==N-1) {
			if(W[row][col]!=0) {
				cost += W[row][col];
				if(cost<min) min = cost;
			}
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(colCheck[i]==false && W[row][i]!=0) {
				colCheck[i]=true;
				dfs(col,i,cost+W[row][i],count+1);
				colCheck[i]=false;
			}
		}
	}
}
