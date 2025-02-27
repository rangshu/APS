package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17427_약수의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long gn = 0;

        // g(N)은 1 부터 N까지의 모든 숫자가 가진 모든 약수의 합을 더하는 것이다.
        // 따라서, 1 부터 N까지의 모든 숫자가 가진 모든 약수의 합은
        // 1부터 N 까지 각 숫자의 약수에서, 각 숫자가 몇개씩 들어있는지 확인하면 된다.
        // 예를 들어: g(5) 를 계산한다고 하면.
        // 1: 1
        // 2: 1, 2
        // 3: 1, 3
        // 4: 1, 2, 4
        // 5: 1, 5
        // 위와 같이 각 숫자별로 약수를 구할 수 있는데,
        // 1은 모든 수의 약수이므로, 전부 더해주고,
        // 2는 2의 배수는 2, 4만 가지고 있으므로 2번만 더해주고
        // 3은 3의 배수는 3 만 가지고 있으므로 1번만 더해주는 식으로 계산할 수 있다.
        // i * j <= N 이 배수를 계산해주는 식이 된다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; i*j <= N; j++) {
                gn = gn + i;
            }
        }

        System.out.println(gn);
    }
}
