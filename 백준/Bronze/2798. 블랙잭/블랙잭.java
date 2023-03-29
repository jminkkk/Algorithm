import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        //블랙잭의 규칙
        //N장의 카드 중에서 3장의 카드 고르고
        //M을 넘지 않으면서 M과 최대한 가깝게
        //N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합

        // 입력 : N, M
        // 둘째 줄에는 카드에 쓰여 있는 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken()); // 카드 수
        Integer M = Integer.parseInt(st.nextToken());
        Integer[] card = new Integer[N]; //각 카드에 쓰여있는 숫자

        String[] cardStr = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(cardStr[i]);
        }

        // 출력 : 합
        System.out.println(blackJack(card, M));
    }

    private static int blackJack(Integer[] card, Integer m) {
        //N장의 카드 중에서 3장의 카드 고르고
        //M을 넘지 않으면서 M과 최대한 가깝게
        //N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합
        int tmp = 0;

        for (int i = 0; i < card.length - 2; i++) {
            for (int j = i + 1; j < card.length - 1; j++) {
                for (int k = j + 1; k < card.length; k++) {
                    int sum = card[i] + card[j] + card[k]; // 3개의 숫자의 합

                    if(tmp < sum && m >= sum) { //갱신
                        tmp = sum;
                    }
                }
            }
        }

        return tmp;
    }
}