import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Test Case의 갯수
        StringBuilder sb = new StringBuilder();
        String pattern = "^[A-F]?A+F+C+[A-F]?$";

        for(int i =0; i < T; i++) {
            String str = br.readLine();
            if(str.matches(pattern)) sb.append("Infected!").append("\n");
            else sb.append("Good").append("\n");
        }
        System.out.println(sb);
    }

}