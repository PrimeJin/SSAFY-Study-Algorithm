import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1735_분수합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A1 = Integer.parseInt(st.nextToken());
		int B1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int A2 = Integer.parseInt(st.nextToken());
		int B2 = Integer.parseInt(st.nextToken());
		
		//최소 공배수 찾기
		int bunmo = B1*B2;
		int bunja = A1*B2 + A2*B1;
		
		int num = Math.min(bunja, bunmo);
		while(bunmo>1 && bunja>1 && num>0) {
			if(bunmo % num == 0) {
				if(bunja % num == 0) {
					bunmo /= num;
					bunja /= num;
				}
			}
			num--;
		}
		
		System.out.println(bunja + " " + bunmo);
	}
}	
