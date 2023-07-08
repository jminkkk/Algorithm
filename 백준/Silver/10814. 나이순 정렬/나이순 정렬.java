
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine()); // 회원의 수
        String[] original = new String[N]; // 입력값 : 나이 이름

        String[] age = new String[N]; // 나이 각각 저장
        String[] name = new String[N]; // 이름 각각 저장

        String[] answer = new String[N]; // 정렬된 정답 저장

        int count = 1;
        int index = 0;

        for (int i = 0; i < N; i++) {
            original[i] = br.readLine();
            String[] person = original[i].split(" ");

            age[i]= person[0]; // age
            name[i] = person[1]; // name
        }

        while (true) { // 0부터 모든 배열이 정답에 추가될 때까지 (정렬될 때까지)
            for (int i = 0; i < N; i++) {
                if (count == Integer.parseInt(age[i])) {
                    answer[index++] = original[i];
                }
            }

            if (index == N) break;

            count++;
        }

        for (String i : answer) {
            System.out.println(i);
        }
    }
}
