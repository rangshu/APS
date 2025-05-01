import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3085_사탕게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        // 최대 개수
        int max = 0;

        // map 배열에 저장
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int checkMapResult = checkMap(N, map, i, j);
                if (checkMapResult > max) {
                    max = checkMapResult;
                }
            }
        }

        System.out.print(max);
    }

    // i, j 기준으로 오른쪽과 바꿨을 경우와, 아래쪽과 바꿧을 경우의 최대값을 리턴한다.
    public static int checkMap(int N, char[][] map, int i, int j) {
        int max = 0;
        char temp;

        // 오른쪽과 바꾸는 경우
        if (j + 1 < N) {
            int temp_max = 0;
            // 값 바꾸기
            map = changeValue(map, i, j, i, j+1);

            // max 검사
            temp_max = checkMax(map, i, i, j, j+1);

            if (temp_max > max) {
                max = temp_max;
            }

            map = changeValue(map, i, j+1, i, j);
        }

        // 아래쪽과 바꾸는 경우
        if (i + 1 < N) {
            int temp_max = 0;
            // 값 바꾸기
            map = changeValue(map, i, j, i+1, j);
            // max 검사
            temp_max = checkMax(map, i, i+1, j, j);

            if (temp_max > max) {
                max = temp_max;
            }

            // 원상복귀
            map = changeValue(map, i+1, j, i, j);
        }

        return max;
    }

    public static char[][] changeValue(char[][] map, int i, int j, int k, int l) {
        char temp;
        temp = map[i][j];
        map[i][j] = map[k][l];
        map[k][l] = temp;

        return map;
    }

    public static int checkMax(char[][] map, int start_row, int end_row, int start_col, int end_col) {
        int n = map.length;
        int ans = 1;

        for (int i = start_row; i <= end_row; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (map[i][j-1] == map[i][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if (cnt > ans) {
                    ans = cnt;
                }
            }
        }

        for (int j = start_col; j <= end_col; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (map[i - 1][j] == map[i][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if (cnt > ans) {
                    ans = cnt;
                }
            }
        }

        return ans;
    }
}
