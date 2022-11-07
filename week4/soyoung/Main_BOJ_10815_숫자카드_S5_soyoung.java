package ps0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main_BOJ_10815_숫자카드_S5 {
	static int my[];
	
	public static int contains(int num, int start, int end) {
		if(start > end) return 0; //not found

		int mid = (start+end)/2;
		if(num == my[mid]) return 1;
		else if(num < my[mid]) return contains(num, start, mid-1);
		else return contains(num, mid+1, end);
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //상근이가 가진 카드 개수
		st = new StringTokenizer(br.readLine());
		my = new int[N];
		for (int i = 0; i < N; i++) {
			my[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(my); //정렬
		int M = Integer.parseInt(br.readLine()); //가지고 있는지 확인할 카드 개수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(contains(Integer.parseInt(st.nextToken()), 0, N-1) + " ");
		}
		System.out.println(sb.toString());
	}//main
}
