import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_15990_123더하기5_S2 {

    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int max = 0;
        int tests[] = new int[T];
        for (int tc = 0; tc < T; tc++) {
            tests[tc] = Integer.parseInt(br.readLine());
            max = Math.max(max, tests[tc]);
        }

        //dp
        //dp[i][j]: i로 시작하는 j만들기 경우의 수
        //=> j 만드는 경우의 수: dp[1][j] + dp[2][j] + dp[3][j]

        dp = new int[4][max+1];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;

        for (int i = 3; i <= max; i++) {
            //1이 아닌 다른 숫자로 시작하는 (i-1) 만들기 경우의 수의 합
            dp[1][i] = (dp[2][i-1]+dp[3][i-1])%1000000009;

            //2이 아닌 다른 숫자로 시작하는 (i-2) 만들기 경우의 수의 합
            dp[2][i] = (dp[1][i-2]+dp[3][i-2])%1000000009;

            //3이 아닌 다른 숫자로 시작하는 (i-3) 만들기 경우의 수의 합
            if(i >= 4){
                dp[3][i] = (dp[1][i-3]+dp[2][i-3])%1000000009;
            }
        }

        //print results
        for (int tc = 0; tc < T; tc++) {
            System.out.println(find(tests[tc]));
        }
    }

    public static int find(int n) {
        return (((dp[1][n]+dp[2][n])%1000000009)+dp[3][n])%1000000009;
    }
}
