import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 단어의 개수
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(checkGroup(str) == true) count++;
        }

        System.out.println(count);
    }

    private static Boolean checkGroup(String str) {
        Boolean[] check = new Boolean[26]; // 한번 나오면 true
        //Boolean을 썼더니 x
        int prev = 0;

        for(int j =0; j<str.length();j++){
            int now = str.charAt(j);

            if(prev != now)
                if(check[now -'a'] == null) {// 해당 문자가 처음 나오는 경우 (false 인 경우)
                    check[now - 'a'] = true;
                    prev = now;
                }
                else return false;
        }
        return true;
    }
}