import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1735_분수합_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Anum, Aden, Bnum, Bden;

        st = new StringTokenizer(br.readLine());
        Anum = Integer.parseInt(st.nextToken());
        Aden = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Bnum = Integer.parseInt(st.nextToken());
        Bden = Integer.parseInt(st.nextToken());

        int num = Anum*Bden + Bnum*Aden;
        int den = Aden * Bden;

        int gcd = 2;
        while(gcd > 1) { //서로소가 될 때까지
            //gcd구하기
            gcd = gcd(num, den);
            //gcd로 둘 다 나누기
            num /= gcd;
            den /= gcd;
        }
        System.out.println(num+" "+den);
    }

    private static int gcd(int num1, int num2) {
        //gcd(a,b) = gcd(b, a%b) = ... =g(gcd, 0)
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return Math.abs(num1);
    }


}
