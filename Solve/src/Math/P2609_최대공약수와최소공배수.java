package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(GCD(A, B));
        System.out.println(LCM(A, B));
    }

    private static int GCD(int A, int B) {
        int max = Math.max(A, B);
        int min = Math.min(A, B);

        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }

    // 최소 공배수는 GCD * (A / GCD) * (B / GCD)
    private static long LCM(int A, int B) {
        return A * (B / GCD(A, B));
    }
}
