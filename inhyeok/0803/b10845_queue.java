
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10845_queue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Queue q=new Queue();
		
		for(int i=0;i<n;i++) {
			String command=br.readLine();
			
			switch(command.charAt(0)) {
			case('p'):
				if(command.charAt(1)=='u') {//push
					int in=Integer.parseInt(command.substring(5));
					q.push(in);
				}
				else {//pop
					System.out.println(q.pop());	
				}
				break;
			
			case('s')://size
				System.out.println(q.size());
				break;
				
			case('e')://empty
				System.out.println(q.empty());
				break;
			
			case('b')://back
				System.out.println(q.back());
				break;
			
			case('f')://front
				System.out.println(q.front());
				break;
			}
		}
	}

}

class Queue{
	int[] a=new int[10000];
	
	int index=0;
	int first=0;
	
	void push(int n) {
		a[index++]=n;
	}
	
	int pop() {
		if(index-first!=0) {
			return a[first++];
		}
		return -1;
	}
	
	int size() {
		return index-first;
	}
	
	int empty() {
		if(index-first!=0){
			return 0;
		}
		return 1;
	}
	
	int back() {
		if(index-first!=0) {
			return a[index-1];
		}
		return -1;
	}
	
	int front() {
		if(index-first!=0) {
			return a[first];
		}
		
		return -1;
	}
}
