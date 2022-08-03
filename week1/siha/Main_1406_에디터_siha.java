import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1406_에디터_siha {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = null;
		LinkedList<Character> list = new LinkedList<Character>();
	
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());	
		
		for(int i=0;i<str.length();i++) {
			list.add(str.charAt(i));
		}
		
		int cursur = list.size();
		
		
//	       0  1  2  3  4  5	
		// [0, 1, 2, 3, 4]
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			String comm = st.nextToken();
			
			if(comm.equals("L")) {
				if(cursur > 0 )	cursur -= 1;
			}
			else if(comm.equals("D")) {
				if(cursur < list.size()) cursur += 1;
			}
			else if(comm.equals("B")) {
				if(cursur > 0 ) {
					list.remove(cursur-1);
					cursur--;
				}	
								
			}
			else if(comm.equals("P")) {
				list.add(cursur++, st.nextToken().charAt(0));
			}
			
			
		}
		
		for (Character i : list) {
			System.out.print(i);
		}

	}

}
