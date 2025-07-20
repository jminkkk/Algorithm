import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        Dumb dumb = new Dumb(str[0], str[1], str[2]);
        System.out.println(dumb.toString());
    }
}

class Dumb {
    String code;
    String color;
    String second;

    public Dumb(String code, String color, String second) {
        this.code = code;
        this.color = color;
        this.second = second;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("code: ").append(code).append("\n");
        sb.append("color: ").append(color).append("\n");
        sb.append("second: ").append(second).append("\n");
        return sb.toString();
    }
}