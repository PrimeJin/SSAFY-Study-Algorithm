import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_2644_촌수계산_soyoung {
	static int N, p1, p2, edges;
	static int map[];

	// p1과 p2의 촌수를 계산하는 함수
	public static int dfs(int p1, int p2) {
		ArrayList<Integer> ancestors1 = new ArrayList<>();
		ArrayList<Integer> ancestors2 = new ArrayList<>();

		while (p1 != 0) {
			ancestors1.add(p1);
			p1 = map[p1];
		}
		while (p2 != 0) {
			ancestors2.add(p2);
			p2 = map[p2];
		}

		int i = 0, j = 0;
		for (i = 0; i < ancestors1.size(); i++) {
			for (j = 0; j < ancestors2.size(); j++) {
				if (ancestors1.get(i) == ancestors2.get(j)) {
					return i + j;
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		edges = Integer.parseInt(br.readLine());

		map = new int[N + 1]; // 나의 부모 저장
		for (int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 부모
			int b = Integer.parseInt(st.nextToken()); // 자식
			map[b] = a; // 자식 인덱스에 부모 번호 저장
		}

		System.out.println(dfs(p1, p2));
	}
}