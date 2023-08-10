
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static int[][] A;
    static boolean[][] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);
        A = new int[2][N];
        robot = new boolean[2][N];

        for (int i = 0; i < N; i++) {
            A[0][i] = Integer.parseInt(str[i]);
            A[1][N - 1 - i] = Integer.parseInt(str[N + i]);
        }

        int round = 0;

        while (true) {
            if (isFinished()) break;

            step1();
//            System.out.println();
//            System.out.println("Step1" );
//            printA();
//            whereIsRobot();
            robotTakeOff();

            step2();
//            System.out.println();
//            System.out.println("Step2" );
//            printA();
//            whereIsRobot();
            robotTakeOff();

            step3();
//            System.out.println();
//            System.out.println("Step3" );
//            whereIsRobot();
//            printA();


            round++;

//            System.out.println();
//            System.out.println("round는 " + round);
//            System.out.println("-------------");
        }

        System.out.println(round);
    }

    private static void printA() {
        for (int i = 0; i < N; i++) {
            System.out.print(A[0][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(A[1][i] + " ");
        }
    }

    private static void whereIsRobot() {
        for (int i = 0; i < N; i++) {
            if (robot[0][i]) System.out.print("로봇 여기 있다: 0 " + i);
            if (robot[1][i]) System.out.print("로봇 여기 있다: 1 " + i);
        }
        System.out.println();
    }
    private static void step1() {
        // N자리, 2N
        int tmpN1 = A[0][N - 1];
        boolean robotN1 = robot[0][N - 1];
        int tmp2N = A[1][0];
        boolean robot2N = robot[1][0];


        for (int i = N - 1; i >= 1; i--) {
            // ->
            A[0][i] = A[0][i - 1];

            if (robot[0][i - 1]) { // 로봇이 있다면 로봇도 함께 이동
                robot[0][i - 1] = false;
                robot[0][i] = true;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            // <-
            A[1][i] = A[1][i + 1];

            if (robot[1][i + 1]) { // 로봇이 있다면 로봇도 함께 이동
                robot[1][i + 1] = false;
                robot[1][i] = true;
            }
        }

        A[0][0] = tmp2N;
        robot[0][0] = robot2N;
        A[1][N - 1] = tmpN1;
        robot[1][N - 1] = robotN1;
    }

    private static void step2() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[0][i] && !robot[0][i + 1] && A[0][i + 1] >= 1) {
                // 이동
                robot[0][i] = false;
                robot[0][i + 1] = true;
                // 내구도 감소
                A[0][i + 1]--;

                robotTakeOff();
            }
        }

//        for (int i = 0; i < N; i++) {
//            if (robot[1][i] && !robot[1][i - 1] && A[1][i - 1] >= 1) {
//                // 이동
//                robot[1][i] = false;
//                robot[1][i - 1] = true;
//                // 내구도 감소
//                A[1][i - 1]--;
//
//                robotTakeOff();
//            }
//        }
    }

    private static void step3() {
        if (!robot[0][0] && A[0][0] > 0) {
            robot[0][0] = true;
            A[0][0]--;
        }
    }

    private static void robotTakeOff() {
        if (robot[0][N - 1]) robot[0][N - 1] = false;
    }

    private static boolean isFinished() {
        int zeroCount = 0;
        for (int i = 0; i < N; i++) {
            if (A[0][i] <= 0) zeroCount++;
            if (A[1][i] <= 0) zeroCount++;
        }
        return zeroCount >= K;
    }
}
