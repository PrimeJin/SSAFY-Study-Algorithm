import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10845_woojin {  //10845.큐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		int back = 0;  //큐의 가장 뒤에 있는 정수를 가리킬 변수
		for(int i=0; i<N; i++) {
			String command = br.readLine();
			
			if(command.contains("push")) {
				back = Integer.parseInt(command.substring(5));
				queue.offer(back);
			} else if(command.equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}
			} else if(command.equals("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());  //가장 먼저 들어온 수 
				}
			} else if(command.equals("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(back);  //가장 마지막에 들어온 수
				}
			} else if(command.equals("size")) {
				System.out.println(queue.size());
			} else if(command.equals("empty")) {
				System.out.println(queue.isEmpty() ? 1:0);  //큐 비어있으면 1 아니면 0 출력
			} 
		}
	}
}
