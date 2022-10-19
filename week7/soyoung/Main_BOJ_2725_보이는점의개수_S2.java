import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2725_보이는점의개수_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[][] hiden = new boolean[1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if(i==0 && j==0) continue;
                if(!hiden[i][j]) {
                    int r = i*2;
                    int c = j*2;
                    while(r<=1000 && c<=1000) {
                        hiden[r][c] = true;
                        r += i; c += j;
                    }
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int visible = 0;
            for (int i = 0; i < N+1; i++) {
                for (int j = 0; j < N+1; j++) {
                    if(i==0 && j==0) continue;
                    if(!hiden[i][j]) visible++;
                }
            }
            sb.append(visible+"\n");
        }
        System.out.print(sb);
    }
}
