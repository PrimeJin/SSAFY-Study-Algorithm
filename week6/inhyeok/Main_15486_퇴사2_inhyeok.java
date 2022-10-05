import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] time;
	static int[] pay;
	static int[] max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		time=new int[n+1];
		pay=new int[n+1];
		max=new int[n+2];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			time[i]=Integer.parseInt(st.nextToken());
			pay[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {
			if(max[i]<max[i-1]) {
				max[i]=max[i-1];
			}
			if(i+time[i]<=n+1) {
				if(max[i+time[i]]<max[i]+pay[i]) {
					max[i+time[i]]=max[i]+pay[i];
				}
			}
		}
		
		if(time[n]==1) {
			if(max[n+1]<max[n]+pay[n])
			{max[n+1]=max[n]+pay[n];}
		}
		else {
			if(max[n+1]<max[n])
			{max[n+1]=max[n];}
		}
		
		System.out.println(max[n+1]);
	}

}
