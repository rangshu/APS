package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1929_소수구하기 {

    private static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean prime[] = new boolean[MAX + 1];
        Arrays.fill(prime, true);

        // false = 소수가 아님
        // true = 소수
        prime[0] = prime[1] = false;

        // 에라토스테네스의 체 구현
        for (int i = 2; i * i <= MAX; i++) {

            if (prime[i] == false) {
                continue;
            }

            for (int j = i * i; j <= MAX; j+=i) {
                prime[j] = false;
            }
        }

        for (int i = a; i <= b; i++) {
            if (prime[i]) {
                System.out.println(i);
            }
        }
    }
}
