import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int sum = 0;
    // Hamming Distance의 합
    // N 중에 해당 번째의 뉴클레오가 다른 DNA의 갯수 빼기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 뉴클레오티드 A, T, G, C
        // Hamming Distance 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 갯수
        // N개의, 길이가 M인 DNA가 주어질 때
        // Hamming Distance의 합이 가장 작은 DNA s를 구하라
        // s&s1 + s&s2 + s&s3 + s&s4 + s&s5 = 최소

        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());
        String[] DNA = new String[N];


        for (int i = 0; i < N; i++) { // n개의 DNA
            DNA[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            sb.append(solution(i, DNA));
        }

        System.out.println(sb);
        System.out.println(sum);

    }

    private static char solution(int i, String[] DNA) {
        int[] newCleo = new int[4];

        for (int j = 0; j < DNA.length; j++) {
            // DNA[j] 문자열의 i번째 문자와 비교하여 newCleo 배열 업데이트
            switch (DNA[j].charAt(i)) {
                case 'A':
                    newCleo[0]++;
                    break;
                case 'C':
                    newCleo[1]++;
                    break;
                case 'G':
                    newCleo[2]++;
                    break;
                case 'T':
                    newCleo[3]++;
                    break;
            }
        }

        int max = 0;
        int maxIndex = 0;

        for (int k = 0; k < newCleo.length; k++) {
            if (newCleo[k] > max) {
                max = newCleo[k];
                maxIndex = k;
            }
            else if (newCleo[k] == max) {
                if((char) k < (char) maxIndex) maxIndex = k;
            }
        }

        sum += (DNA.length - max);

        if (maxIndex == 0) return 'A';
        else if (maxIndex == 1) return 'C';
        else if (maxIndex == 2) return 'G';
        else return 'T';
    }
}