import java.util.*;

class Main_2960_에라토스테네스의체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] check = new boolean[N+1];
		int count = 0;
		loop1 : for(int i=2; i<N+1; i++) {
			for(int j=i; j<N+1; j+=i) {
				if(check[j] == false) {
					check[j] = true;
					count++;
				}
				if(count == K) {
					System.out.println(j);
					break loop1;
				}
			}
		}
    }
}