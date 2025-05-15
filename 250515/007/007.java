import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode = sc.next();
        String mPoint = sc.next();
        int time = sc.nextInt();
        // Please write your code here.
        Code code = new Code(sCode, mPoint, time);
        System.out.print(code.toString());
    }
}

class Code {
    String code;
    String meetingPoint;
    int time;

    Code(String code, String meetingPoint, int time) {
        this.code = code;
        this.meetingPoint = meetingPoint;
        this.time = time;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("secret code : ").append(code).append("\n");
        sb.append("meeting point : ").append(meetingPoint).append("\n");
        sb.append("time : ").append(time);
        return sb.toString();
    }
}