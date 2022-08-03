import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main_10828_스택_siha {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int top = -1;
		int[] stack = new int[n];
		
	
		for (int i = 0; i < n; i++) {
			
			st = new StringTokenizer(in.readLine());					
			String comm = st.nextToken();
			if(comm.equals("push")) {				
				stack[top+1] = Integer.parseInt(st.nextToken());
				top++;
			}
			else if(comm.equals("pop")) {
				if(top == -1) System.out.println(-1);
				else{
					System.out.println(stack[top--]);			
//					top--;
				}
				
			}
			else if(comm.equals("size")) {
				System.out.println(top + 1);
			}
			else if(comm.equals("empty")) {
				if(top == -1) System.out.println(1);
				else	System.out.println(0);
			}
			else if(comm.equals("top")) {
				if(top == -1)	System.out.println(-1);
				else 	System.out.println(stack[top]);
			}
			
						
		}
		
		
		
	}//main
	
}
