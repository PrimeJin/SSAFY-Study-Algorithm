import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10816_숫자카드2_siha {
	
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] plusCard = new int[10000001];
		int[] minusCard = new int[10000001];
		int num = 0;
		
		for(int i=0;i<N;i++) {
			num = Integer.parseInt(st.nextToken());
			if(num>0)	plusCard[Math.abs(num)] += 1;
			else		minusCard[Math.abs(num)] += 1;			
		}
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			
			num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				sb.append(plusCard[num] + " ");
			}
			else {
				sb.append(minusCard[Math.abs(num)] +  " ");
			}
			
		}
		
		System.out.println(sb);
				
		
	}
}
