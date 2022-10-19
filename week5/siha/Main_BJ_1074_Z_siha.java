import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1074_Z_siha {
	
	static int N, r, c, cnt;
	static int powN;
	static int[] dx = {0, 0,  1,  0};
	static int[] dy = {0, 1, -1,  1};
	static boolean flag;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		powN = (int)Math.pow(2, N);
		
		
		mergeSort(0, 0, powN);

		
	}

	private static void mergeSort(int x, int y, int size) {
			
		if(x == r && y == c) {
			System.out.println(cnt);
			System.exit(0);
		}
		
	
		if(x <= r && r < x+size && y <= c && c < y+size) {
			
			int mid = size/2;
			mergeSort(x, y, mid);
			mergeSort(x, y+mid, mid);
			mergeSort(x+mid, y, mid);
			mergeSort(x+mid, y+mid, mid);
			
		}
		else {
			cnt += (size * size);
		}
		
	}
	

	
	
}
