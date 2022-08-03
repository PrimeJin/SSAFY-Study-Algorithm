import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class b1406_modified {

	public static void main(String[] args) throws Exception {
		//Scanner sc=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//프린트보다 빨라서 넣었다. 최대 속도를 위해
		
		String all=br.readLine();
		LinkedList<Character> b=new LinkedList<>();
		
		for(int i=0;i<all.length();i++) {
			b.add(all.charAt(i));
		}
		
		
		int n=Integer.parseInt(br.readLine());
		
		ListIterator<Character> iter=b.listIterator();
		
		while(iter.hasNext()) {
			iter.next();
			//다음값이 있으면 리턴후 커서를 이동시키는 함수
			//iterator를 사용하면 시간복잡도가 n이다.
		}
		
		for(int i=0;i<n;i++) {
			String command=br.readLine();
			
			switch(command.charAt(0)) {
			case('L'):
				if(iter.hasPrevious()) {iter.previous();}
				break;
				
			
			case('D'):
				if(iter.hasNext()){iter.next();}
				break;
			
			case('B'):
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
					//리무브 함수를 사용하면 현재 커서에 있는 자료를 지운다.
					//previous를 통해 앞으로 한칸 당긴후 해당 자료를 삭제한다.
					//그럼 다시 처음에 가르키던 값을 가르키는 위치에 커서가 가기때문에, 커서를 추가로 움직일 필요는 없다.
				}
				break;
				
			case('P'):
				iter.add(command.charAt(2));
				//이터레이터 현재 위치에 스캔한 캐릭터를 더한다
				//현재 커서가 가르키는 자료의 다음순서에 더한 후, 해당 자료를 커서가 가르키기 때문에 커서를 이동시킬 필요는 없다.
				break;
			}	
		}
		for(Character chr : b) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}

}
