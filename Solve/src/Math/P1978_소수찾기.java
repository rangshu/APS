package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1978_소수찾기 {

    private static int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개의 수
        int N = Integer.parseInt(br.readLine());

        // 소수의 개수
        int primeCnt = N;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int checkNo = Integer.parseInt(st.nextToken());

            if (checkNo == 0 || checkNo == 1) {
                primeCnt--;
                continue;
            }

            // j * j 는 루트(checkNo) 를 뜻한다.
            for (int j = 2; j * j <= checkNo; j++) {
                if (checkNo % j == 0) {
                    primeCnt--;
                    break;
                }
            }
        }

        System.out.println(primeCnt);
    }
}
