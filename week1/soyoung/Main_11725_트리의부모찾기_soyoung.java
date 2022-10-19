import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기_soyoung {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int child, parent;
        boolean findParent;
        int temp;
        int temp2;

        int N = Integer.parseInt(br.readLine()); // num of Nodes
        int[] nums = new int[N + 1];

        for (int i = 0; i < N - 1; i++) { // edges
            st = new StringTokenizer(br.readLine());
            child = Integer.parseInt(st.nextToken());
            parent = Integer.parseInt(st.nextToken());
            findParent = false;

            while (!findParent) {
                // 내가 1이면 swap
                if (child == 1) {
                    temp = child;
                    child = parent;
                    parent = temp;
                }
                if (nums[child] == 0) { // 나에게 부모가 없다면 부모 입력
                    nums[child] = parent;
                    findParent = true;
                } else { // 나에게 기존 부모가 있다면
                    if (parent == 1) { // 새부모로 변경
                        temp = nums[child];// 현재부모 임시자식으로 변경
                        nums[child] = parent;
                        parent = child;
                        child = temp;
                    } else { // 원래 부모가 1이면
                        temp = child;
                        child = parent;
                        parent = temp;
                    }
                }
            }
        } // for every edge
        for (int i = 2; i < nums.length; i++) {
            bw.write(nums[i] + "\n");
        }
        bw.close();

    }// main
}