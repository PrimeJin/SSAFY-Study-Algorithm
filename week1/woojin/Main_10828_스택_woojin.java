import java.util.Scanner;
import java.util.Stack;

public class Main_10828_woojin {  //10828.스택
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String str = sc.next();
			if(str.equals("push")) {
				stack.push(sc.nextInt());
			} else if(str.equals("top")) {
				if(stack.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(stack.peek()).append('\n');
				}
			} else if(str.equals("size")) {
				sb.append(stack.size()).append('\n');
			} else if(str.equals("empty")) {
				sb.append(stack.isEmpty() ? 1 : 0).append('\n');
			} else if(str.equals("pop")) {
				if(stack.isEmpty()) {  //스택이 비어서 pop할게 없으면 -1출력
					sb.append(-1).append('\n');
				} else {
					sb.append(stack.pop()).append('\n');
				}
			}
		}
        System.out.println(sb);
    }
}
