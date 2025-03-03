package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17425_약수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MAX = 1000001;
        long f[] = new long[MAX];
        long g[] = new long[MAX];

        Arrays.fill(f, 1); // 모든 숫자는 1을 약수로 가지고 있다.

        // 2 부터 MAX까지 모든 배수를 더해준다.
        // f(x)를 구하는 방법
        // f(x)는 x가 가진 약수의 합
        // 예 : f(3) 이면, 1 + 3 이므로
        // i가 2일때는 아무것도 안하고, i가 3일때, f[3 * 1] += 3 이 되어서, 기존 1 과 3이 더해진다.
        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i*j < MAX; j++) {
                f[i*j] += i;
            }
        }

        // g(x)는 f(1) ~ f(x) 까지의 합
        // g(x) = g(x-1) + f(x)
        for (int i = 1; i < MAX; i++) {
            g[i] = g[i-1] + f[i];
        }

        StringBuilder sb = new StringBuilder();

        while(N > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(g[n] + "\n");
            N--;
        }

        System.out.println(sb);
    }
}
