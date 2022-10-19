package ps0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10816_숫자카드2_S4 {
	public static int find = 0;
	public static int count = 1;
	
	
	public static void contains(int num, int start, int end, int[] deck) {
		
		if(start > end) return; //not found

		int mid = (start+end)/2;
//		System.out.println(count++ + ", "+start+"~"+end+", mid: "+mid);
		if(num == deck[mid]) find++;
		
		if((mid+1)<=end && num >= deck[mid+1]) contains(num, mid+1, end, deck);
		if((mid-1)>=start && num <= deck[mid-1]) contains(num, start, mid-1, deck);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int deckSize = Integer.parseInt(br.readLine());
		int[] deck = new int[deckSize];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < deckSize; i++) {
			deck[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(deck);
		
		int mySize = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < mySize; i++) {
			int num = Integer.parseInt(st.nextToken());
//			System.out.println("find "+num);
			find = 0; count = 1;
			contains(num, 0, (deckSize-1), deck);
			sb.append(find+" ");
		}
		System.out.println(sb);
	}
}
