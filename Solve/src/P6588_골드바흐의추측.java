import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P6588_골드바흐의추측 {

    private static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        // true : 소수, false : 소수가 아님
        boolean[] primes = new boolean[MAX + 1];
        Arrays.fill(primes, true);

        // 0, 1은 소수가 아님
        primes[0] = primes[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            for (int j = i * i; j <= MAX; j+=i) {
                primes[j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            for (int i = 3; i < n; i++) {
                if (primes[i] && primes[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append(System.lineSeparator());
                    break;
                }
            }
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());
    }
}
