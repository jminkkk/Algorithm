import java.io.*;
import java.util.*;

import static java.util.Comparator.naturalOrder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int noHear = Integer.parseInt(st.nextToken()); //듣도 못한 사람
        int noSee = Integer.parseInt(st.nextToken()); //보도 못한 사람
        ArrayList<String> noHearSee = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < noHear; i++) {
            set.add(br.readLine());
        }

        for(int i = 0; i<noSee; i++) {
            String str = br.readLine();
            if(set.contains(str)) noHearSee.add(str);
        }

        Collections.sort(noHearSee);

        System.out.println(noHearSee.size());
        for(String s : noHearSee) {
            System.out.println(s);
        }
    }
}