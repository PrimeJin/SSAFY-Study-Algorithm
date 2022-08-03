import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10845_woojin2 {  //10845.큐
	static int[] arr = new int[10001];  //명령의수 1<=N<=10000
	static int index = 0;
	static int count = 0;  //pop한 개수
	public static void main(String[] args) throws IOException {
		Main_10845_woojin2 que = new Main_10845_woojin2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String command = br.readLine();

			if(command.contains("push")) {
				que.push(Integer.parseInt(command.substring(5)));
			} else if(command.equals("pop")) {
				System.out.println(que.pop());
			} else if(command.equals("front")) {
				System.out.println(que.front());
			} else if(command.equals("back")) {
				System.out.println(que.back());
			} else if(command.equals("size")) {
				System.out.println(que.size());
			} else if(command.equals("empty")) {
				System.out.println(que.empty());
			} 
		}
		
		
	}
	
	public void push(int n) {
		arr[index] = n;
		index++;
	}
	
	public int pop() {
		Main_10845_woojin2 que = new Main_10845_woojin2();
		if(que.empty()==1) {
			return -1;
		} else {
			count++;
			return arr[count-1];
		}
		
	}
	
	public int size() {
		return index-count;
	}
	
	public int empty() {
		if(index-count == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int front() {
		Main_10845_woojin2 que = new Main_10845_woojin2();
		if(que.empty()==1) {
			return -1;
		} else {
			return arr[count];
		}
	}
	
	public int back() {
		Main_10845_woojin2 que = new Main_10845_woojin2();
		if(que.empty()==1) {
			return -1;
		} else {
			return arr[index-1];
		}
	}
}