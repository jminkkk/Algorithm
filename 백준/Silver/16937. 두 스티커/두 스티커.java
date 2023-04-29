
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 두 스티커
public class Main {
    // 크기 HxW인 모눈종이
    // 스티커 N개
    // i번째 스티커의 크기 RixCi
    // 모눈종이에 스티커 2개
    // 스티커가 붙여진 넓이의 최대값

    static int H;
    static int W;
    static Boolean[][] visited;
    static Integer[][] sticker;
    static Integer max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        // 모눈종이의 크기
        H = Integer.parseInt(str[0]);
        W = Integer.parseInt(str[1]);
        Integer N = Integer.parseInt(br.readLine()); // 스티커의 개수

        sticker = new Integer[N][2];

        // 스티커 받기
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");
            sticker[i][0] = Integer.parseInt(st[0]); // i번째 스티커의 높이
            sticker[i][1] = Integer.parseInt(st[1]); // i번째 스티커의 너비
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int areaSum = solution(i, j);
                if (max < areaSum)
                    max = areaSum;
            }
        }

        if (max == 0) System.out.println("0");
        else System.out.println(max);
    }

    // 1. 두 스티커의 가로, 세로 길이의 합이 전체 모눈종이의 크기보다 작거나 같아야 함
    // 2. 여러개 있다면 넓이의 총합중 최대값


    // a, b 스티커의 넓이의 합
    public static int solution(int i, int j) {
        if (check(i, j)) {
            int aArea = sticker[i][0] * sticker[i][1];
            int bArea = sticker[j][0] * sticker[j][1];
            return aArea + bArea;
        }
        return 0;
    }

    private static boolean check(int i, int j) {
//        if (a <= H && b <= H && c <= W && d <= W) {
//            int max = 0;
//            for (int i = 0; i < 4 ; i++) {
//                if (max < i) max = i;
//            }
//
//            if () {
//
//            return true;
//            }
//        }
//
//        return false;
        // 1. 회전 x
        if (sticker[i][0] <= H && sticker[j][0] <= H && sticker[i][1] + sticker[j][1] <= W) return true;
        else if (sticker[i][1] <= W && sticker[j][1] <= W && sticker[i][0] + sticker[j][0] <= H) return true; //1

        // 2. i만 회전 90도
        else if (sticker[i][1] <= H && sticker[j][0] <= H && sticker[i][0] + sticker[j][1] <= W) return true; // 4
        else if (sticker[i][0] <= W && sticker[j][1] <= W && sticker[i][1] + sticker[j][0] <= H) return true; // 5 ㅠㅠㅠㅠㅠㅠ

        // 3. j만 회전 90도
        else if (sticker[i][0] <= H && sticker[j][1] <= H && sticker[i][1] + sticker[j][0] <= W) return true;
        else if (sticker[i][1] <= W && sticker[j][0] <= W && sticker[i][0] + sticker[j][1] <= H) return true; // 3

        // 4. 둘다 90도 회전
        else if (sticker[i][1] <= H && sticker[j][1] <= H && sticker[i][0] + sticker[j][0] <= W) return true; // 2
        else if (sticker[i][0] <= W && sticker[j][0] <= W && sticker[i][1] + sticker[j][1] <= H) return true;

        return false;
        //  }
//        if (stickers[i][0] + stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1]) <= W || // 1
//                stickers[i][0] + stickers[j][0] <= W && Math.max(stickers[i][1], stickers[j][1]) <= H) return true; // 2
//        else if (stickers[i][0] + stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W || // 3 
//                stickers[i][0] + stickers[j][1] <= W && Math.max(stickers[i][1], stickers[j][0]) <= H) return true; // 4
//        else if (stickers[i][1] + stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W ||
//                stickers[i][1] + stickers[j][0] <= W && Math.max(stickers[i][0], stickers[j][1]) <= H) return true;
//        else if (stickers[i][1] + stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W ||
//                stickers[i][1] + stickers[j][1] <= W && Math.max(stickers[i][0], stickers[j][0]) <= H) return true;
//        return false;
    }
}

