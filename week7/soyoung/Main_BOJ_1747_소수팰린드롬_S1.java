import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1747_소수팰린드롬_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //N 이상이면서 소수이고 팰린드롬인 수
        while(true) {
            //종료조건: 팰린드롬이면서 소수인지 확인
            if(isPalindrome(N) && isPrime(N)) break;
            N++;
        }
        System.out.println(N);
    }

    private static boolean isPrime(int n) {
        if(n == 1) return false;

        for (int i = 2; i*i <= n; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }
}

