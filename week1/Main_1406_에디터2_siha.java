import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_1406_에디터2_siha {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		LinkedList<Character> list = new LinkedList<Character>();
	
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());	
		
		for(int i=0;i<str.length();i++) {
			list.add(str.charAt(i));
		}
		
		ListIterator<Character> iter = list.listIterator();		
		while(iter.hasNext()) {
			iter.next();
		}
		
		
//	       0  1  2  3  4  5	
		// [0, 1, 2, 3, 4]
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			String comm = st.nextToken();
			
			if(comm.equals("L")) {
				if(iter.hasPrevious())	iter.previous();
			}
			else if(comm.equals("D")) {
				if(iter.hasNext()) iter.next();
			}
			else if(comm.equals("B")) {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}	
								
			}
			else if(comm.equals("P")) {
				iter.add(st.nextToken().charAt(0));
			}
			
			
		}
		
		for (Character i : list) {
			bw.write(i);
		}
		
		bw.flush();
	}

}
