package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b10816_숫자카드 {
	
	public static void main(String[] args) throws IOException {
		HashMap<Integer, Integer> has=new HashMap<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int tmp=Integer.parseInt(st.nextToken());
			if(has.containsKey(tmp)) {
				has.put(tmp, has.get(tmp)+1);
			}
			else {
				has.put(tmp, 1);
			}
		}
		
		
		int m=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		while(st.hasMoreTokens()) {
			int tmp=Integer.parseInt(st.nextToken());
			if(has.containsKey(tmp)) {
				sb.append(has.get(tmp));
				sb.append(" ");
			}
			else {
				sb.append(0);
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
