

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int R = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);
        char[][] table = new char[R][C];

        for (int i = 0; i < R; i++) {
            table[i] = br.readLine().toCharArray();
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < C; j++) {
            sb.setLength(0);
            for (int i = 0; i < R; i++) {
                sb.append(table[i][j]);
            }
            list.add(sb.toString());
        }

        int count = 0, start = 0, end = R;
        List<String> tmpList = new ArrayList<>();

        while (start <= end) {
            tmpList.clear();
            int mid = (start + end) / 2;

            for (int i = 0; i < list.size(); i++) {
                String temp = list.get(i);
                temp = temp.substring(mid, temp.length());
                if (!tmpList.contains(temp)) tmpList.add(temp);
                else break;
            }

            if (tmpList.size() != list.size()) end = mid - 1; // 중간부터 끝까지 짜른 것에 중복이 있다는 것
            else { // 중복이 없다 -> 짜를 수 있음
                start = mid + 1;
                count = mid;
            }
        }

        System.out.println(count);
    }
}
