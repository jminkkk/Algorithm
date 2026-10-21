import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        PriorityQueue<File> pq = new PriorityQueue<>();
        for (int i = 0; i < files.length; i++) {
            pq.offer(new File(files[i], i));
        }
        
        for (int i = 0; i < files.length; i++) {
            File f = pq.poll();
            System.out.println(f.fullname);
            answer[i] = f.fullname;
        }
        
        return answer;
    }
}

class File implements Comparable<File> {
    String fullname;
    int index;
    String head;
    int number;
    String tail;
    
    File(String fullname, int index) {
        this.fullname = fullname;
        this.index = index;
        int idx = 0;
        // head
        String headStr = "";
        while (idx < fullname.length() && !Character.isDigit(fullname.charAt(idx))) {
            headStr += fullname.charAt(idx++);
        }
        head = headStr.toUpperCase();
        
        // number
        String numberStr = "";
        while (idx < fullname.length() && Character.isDigit(fullname.charAt(idx))) {
            numberStr += fullname.charAt(idx++);
        }
        number = Integer.parseInt(numberStr);
        
        // tail
        tail = fullname.substring(idx, fullname.length());
    }
    
    public int compareTo(File o) {
        if (!this.head.equals(o.head)) return this.head.compareTo(o.head);
        if (this.number != o.number) return Integer.compare(this.number, o.number);
        return Integer.compare(this.index, o.index);
    }
}