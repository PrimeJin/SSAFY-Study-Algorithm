import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1406_woojin {  //1406.에디터
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();  //초기에 편집기에 입력되어 있는 문자열
		int M = Integer.parseInt(br.readLine());  //입력할 명령어의 개수 
		
		Stack<Character> stack = new Stack<>();
		Stack<Character> temp = new Stack<>();

		//stack에 초기 문장 세팅 작업
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
		}
			
		for(int i=0; i<M; i++) {
			String command = br.readLine();
			
			//명령어 작업
			if(command.equals("L")) {  //커서를 왼쪽으로 한칸 옮기는 작업(커서가 문장의 맨앞이면 무시)
				if(stack.size()>0) {  
					temp.push(stack.pop());  //임시 스택에 하나 덜어서 커서가 원래의 왼쪽을 가리키게함
				}
			} else if(command.equals("D")) {  //커서를 오른쪽으로 한칸 옮기는 작업(커서가 문장의 맨앞이면 무시)
				if(temp.size()>0) {
					stack.push(temp.pop());  //임시 스택에 값이 남아있으면 가져와서 커서를 오른쪽으로 한칸 옮기기
				}
			} else if(command.equals("B")) {
				if(stack.size()>0) {
					stack.pop();  //그냥 문자 삭제
				}
			} else if(command.contains("P")) {  //P $  %라는 문자를 커서 왼쪽에 추가
				stack.push(command.charAt(2));
			}
		}
		//커서 작업 다끝나면 원래 Stack에 다시 다 넣어줘야 완성
		int size = temp.size();
		for(int j=0; j<size; j++) {
			stack.push(temp.pop());
		}
		//결과 출력
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<stack.size(); j++) {
			sb.append(stack.get(j));
		}
		System.out.println(sb);
	}
}
