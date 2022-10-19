import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1) 완전탐색
 * 2) 최소비용신장트리
 */

public class Main_BOJ_10971_외판원순회2_S2 {
	public static int cityNum;
	public static int[][] cost;
	public static int minCost = Integer.MAX_VALUE;
	public static int curCost;
	
	public static int[] temp;
	public static int[] cities;
	public static boolean[] isVisited;
	
	public static void perm(int cnt) {
		if(cnt == cityNum) { //permutation finish
			//calculate travel cost
			curCost = 0;
			for (int i = 0; i < temp.length; i++) {
				int start = temp[i];
				int dest;
				if(i == temp.length-1) {
					dest = temp[0];
				} else {
					dest = temp[i+1];
				}
				if(cost[start][dest] == 0) { //연결된 길이 없으므로 return
					return;
				}
				curCost += cost[start][dest];
			}
			minCost = Math.min(minCost, curCost);
			
		}
		else {
			for (int i = 0; i < cityNum; i++) {
				if(isVisited[i]) continue;
				temp[cnt] = cities[i];
				isVisited[i] = true;
				perm(cnt+1);
				isVisited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//initialize city cost
		cityNum = Integer.parseInt(br.readLine());
		cities = new int[cityNum];
		for (int i = 0; i < cityNum; i++) {
			cities[i] = i; //0, 1, 2, 3, ..., N-1

		}
		cost = new int[cityNum][cityNum];
		for (int i = 0; i < cityNum; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cityNum; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//generate permutation and calcuate cost
		isVisited = new boolean[cityNum];
		temp = new int[cityNum];
		perm(0);
		
		//print output
		System.out.println(minCost);
		
	}
}
