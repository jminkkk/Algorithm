import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        str = br.readLine().split(" ");

        PriorityQueue<Integer> nums = new PriorityQueue<>();
        for (int i = 0; i < str.length; i++) {
            nums.add(Integer.parseInt(str[i]));
        }

        nums.poll();
        PriorityQueue<Integer> listCnt = new PriorityQueue<>();
        listCnt.add(1);
        while (!nums.isEmpty()) {
            int now = nums.poll();
            int smallCnt = listCnt.poll();
            if (now < smallCnt) {
                listCnt.add(1);
                listCnt.add(smallCnt);
            } else {
                listCnt.add(smallCnt + 1);
            }
        }

        System.out.println(listCnt.size());
    }
}
