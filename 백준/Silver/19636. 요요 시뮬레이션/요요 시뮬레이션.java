
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        // 다이어트 전 데시의 체중
        int W0 = Integer.parseInt(str[0]);
        // 일일 에너지 섭취량 및 다이어트 전 일일 기초 대사량
        int I0 = Integer.parseInt(str[1]);
        int T = Integer.parseInt(str[2]);
        str = br.readLine().split(" ");
        // 다이어트 기간 일일 에너지 섭취량은 I
        int D = Integer.parseInt(str[0]);
        int I = Integer.parseInt(str[1]);
        // 다이어트 기간 일일 활동 대사량은 A
        int A = Integer.parseInt(str[2]);

        int w1 = W0;
        int w2 = W0;

        int basic2 = I0;

        for (int i = 0; i < D; i++) {
            w1 += I - (I0 + A);
            w2 += I - (basic2 + A);
            if (Math.abs(I - (basic2 + A)) > T) {
                basic2 += Math.floorDiv(I - (basic2 + A), 2);
            }
        }

        if (w1 <= 0) {
            System.out.println("Danger Diet");
        } else {
            System.out.println(w1 + " " + I0);
        }

        if (w2 <= 0 || basic2 <= 0) {
            System.out.println("Danger Diet");
        } else {
            System.out.print(w2 + " " + basic2 + " ");
            if (I0 - basic2 > 0) 
            {
                System.out.println("YOYO");
            } else {
                System.out.println("NO");
            }
        }
    }
}
