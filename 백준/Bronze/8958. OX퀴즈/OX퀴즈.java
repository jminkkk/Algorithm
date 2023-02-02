import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = new String[N];

        for (int i = 0; i < N; i++) str[i] = br.readLine();

        for (int i = 0; i < N; i++) {
            int a = 0; //연속 횟수
            int sum = 0; //합산 점수

            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) == 'O') {
                    a++;
                } else a = 0;
                sum += a;
            }

            System.out.println(sum);
        }
    }
}