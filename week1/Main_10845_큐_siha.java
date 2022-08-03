import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845_큐_siha {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		Queue<Integer> queue = new LinkedList<>();		
		
		int n = Integer.parseInt(br.readLine());
		int last = 0;
		for (int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());					
			String comm = st.nextToken();
			
			if(comm.equals("push")) {				
				last = Integer.parseInt(st.nextToken());
				queue.add(last);
			}
			else if(comm.equals("pop")) {
				if(queue.size() == 0) System.out.println(-1);
				else{
					System.out.println(queue.poll());		
				}
			}
			else if(comm.equals("size")) {
				System.out.println(queue.size());
			}
			else if(comm.equals("empty")) {
				if(queue.size() == 0) System.out.println(1);
				else	System.out.println(0);
			}
			else if(comm.equals("front")) {
				if(queue.size() == 0)	System.out.println(-1);
				else {
					System.out.println(queue.peek());
				}	
			}
			else if(comm.equals("back")) {
				if(queue.size() == 0)	System.out.println(-1);
				else {
					System.out.println(last);
					
				}
			}
			
						
		}
		
	}//main
}
