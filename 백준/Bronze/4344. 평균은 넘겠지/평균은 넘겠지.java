import java.io.*;
import java.util.StringTokenizer;
//임포트를 꼭 하자...

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine()); //테스트 케이스의 갯수

        String[] str = new String[C];

        for(int i=0; i<C; i++){
            int sum = 0; //학생들 점수의 합
            double mean; //평균
            int a = 0; //평균을 넘는 학생 수
            float per; //평균을 넘는 학생 비율

            str[i] = br.readLine();
            st = new StringTokenizer(str[i]," ");
            int N = Integer.parseInt(st.nextToken()); //학생의 수

            int score[] = new int[N]; //학생들의 점수

            for(int j =0; j<N;j++){
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }

            mean = sum/N; //

            for(int j =0; j<N; j++){
                if(score[j] > mean) a++;
            }
            per = (float) a/N *100;

            //sb.append(String.format("%.6s",String.valueOf(per))).append("%\n");

            System.out.printf("%.3f%%\n", per);
        }
    }
}
