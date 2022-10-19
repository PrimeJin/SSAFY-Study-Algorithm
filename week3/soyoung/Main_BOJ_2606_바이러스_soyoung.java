import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2606_바이러스_soyoung {
    static int N, edges;
    static int map[][];
    static boolean visited[];

    public static int bfs() {
        int cnt = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        // bfs
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (visited[cur])
                continue;
            cnt++;
            visited[cur] = true;
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && visited[i] == false) {
                    q.add(i);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1; // connection
            map[b][a] = 1;
        }

        System.out.println(bfs());
    }
}