import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main_BJ_10815_숫자카드_siha {	//최소 여행비용 구하기

	static int N, M;
	static List<Integer> card;					//같은 숫자는 없음 
	static List<Integer> checkNum;
	static boolean isNum;
	
	
	public static void main(String[] args) throws Exception{				

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		card = new ArrayList<Integer>();
		
		//상근이 카드 
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			card.add(Integer.parseInt(st.nextToken()));
		}
		
		//확인해야할 숫자
		M = Integer.parseInt(br.readLine());
		checkNum = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			checkNum.add(Integer.parseInt(st.nextToken()));
		}
		
		
		Collections.sort(card);		
		
		for(int i=0;i<M;i++) {
			isNum = false;
			binarySearch(checkNum.get(i), 0, N);
			if(isNum) bw.write(1 + " ");
			else	bw.write(0 + " ");
		}
		
		
		bw.flush();
		bw.close();
		
	
	}//main	
	
	
	
	public static void binarySearch(int num, int start, int end) {
		
		
		if(start == end) return;
		
		int mid = (start+end)/2;
		
		if(num == card.get(mid)) {
			isNum = true;
			return;
		}	
		
		if(num > card.get(mid)) {
			binarySearch(num, mid+1, end);
		}
		else {
			binarySearch(num, start, mid);			
		}
		
				
	}//binarySearch
	
}//end class



