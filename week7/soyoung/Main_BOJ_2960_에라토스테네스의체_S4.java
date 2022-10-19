import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
에라토스테네스의 체
 */
public class Main_BOJ_2960_에라토스테네스의체_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[1001];

        int idx = 2;
        int cnt = 0;
        while (idx <= N) {
            for (int i = idx; i <= N; i += idx) {
                //방문 했었다면 다음 숫자로
                if (visited[i]) continue;

                //방문 안했었다면 배수만큼 삭제
                cnt++;
                visited[i] = true;
                if (cnt == K) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
            idx++;
        }

    }//main
}