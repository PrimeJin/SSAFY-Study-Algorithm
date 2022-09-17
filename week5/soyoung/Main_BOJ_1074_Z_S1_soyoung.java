import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main_BOJ_1074_Z_S1 {
    static int N, r, c, arr[][];
    static int count = 0;

    public static void zprint(int curr, int curc, int size){
//        System.out.println("zprint("+curr+", "+curc+", "+size+") and cur Count: "+count);
        if(size==1) {
            if(curr==r && curc==c) {
                System.out.println(count);
            }
            return;
        }

        //4등분
        int newSize = size/2;
        //4구역 중 내가 찾고자 하는 원소가 어디에 있는지 확인 후 해당 구역만 재귀 호출
        //이때 내가 지나친 구역의 크기만큼 count 더해줄것
        if(r<curr+newSize && c<curc+newSize) {
            //지나친 구역이 없으므로 count 더할 필요 없음
            zprint(curr, curc, newSize);
        } else if(r<curr+newSize && c>=curc+newSize){
            count += Math.pow(newSize,2);
            zprint(curr, curc+newSize, newSize);
        } else if(r>=curr+newSize && c<curc+newSize){
            count += Math.pow(newSize,2)*2;
            zprint(curr+newSize, curc, newSize);
        } else {
            count += Math.pow(newSize,2)*3;
            zprint(curr+newSize, curc+newSize, newSize);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);
        zprint(0, 0, size);
    }

}