import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10828_stack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Stack s=new Stack();
		
		for(int i=0;i<n;i++) {
			String command=br.readLine();
			
			switch(command.charAt(0)) {
			case('p'):
				if(command.charAt(1)=='u') {//push
					int in=Integer.parseInt(command.substring(5));
					s.push(in);
					//System.out.println("지금 푸쉬한 숫자: "+ in);
				}
				else {//pop
					System.out.println(s.pop());	
				}
				break;
			
			case('s')://size
				System.out.println(s.size());
				break;
				
			case('e')://empty
				System.out.println(s.empty());
				break;
			
			case('t')://top
				System.out.println(s.top());
				break;
			}
		}
	}

}

class Stack{
	int[] a=new int[10000];
	
	int index=0;
	
	void push(int n) {
		a[index++]=n;
	}
	
	int pop() {
		if(index!=0) {
			return a[--index];
		}
		return -1;
	}
	
	int size() {
		return index;
	}
	
	int empty() {
		if(index!=0){
			return 0;
		}
		return 1;
	}
	
	int top() {
		if(index!=0) {
			return a[index-1];
		}
		return -1;
	}
}
