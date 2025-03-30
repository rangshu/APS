import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2309_일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int heights[] = new int[9];

        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = Integer.parseInt(br.readLine());
            heights[i] = height;

            // 9명 난쟁이의 키 합을 구한다.
            sum += height;
        }
        int i = 0;
        int j = 0;
        boolean flag = false; // 조건을 만족하면 true
        for (i = 0; i < heights.length; i++) {
            for (j = 0; j < heights.length; j++) {
                if (i == j) {
                    continue;
                }

                if (sum - heights[i] - heights[j] == 100) {
                   flag = true;
                   break;
                }
            }

            if (flag) {
                break;
            }
        }

        List ans = new ArrayList();

        for (int k = 0; k < heights.length; k++) {
            if (k == i || k == j) {
                continue;
            }
            ans.add(heights[k]);
        }
        // 오름차순으로 정렬해서 출력한다.
        ans.stream().sorted().forEach(System.out::println);
    }
}
