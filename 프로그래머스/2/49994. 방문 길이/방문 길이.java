import java.awt.*;
import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(String dirs) {
        String[] str = dirs.split("");
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        int nx = 0;
        int ny = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("U") && isValidRange(nx, ny + 1)) {
                ny++;
            } else if (str[i].equals("D") && isValidRange(nx, ny - 1)) {
                ny--;
            } else if (str[i].equals("R") && isValidRange(nx + 1, ny)) {
                nx++;
            } else if (str[i].equals("L") && isValidRange(nx - 1, ny)) {
                nx--;
            } else {
                continue;
            }

            set.add(x + " " + y + " " + nx + " " + ny);
            set.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }
        
        return set.size() / 2;
    }
    
    private boolean isValidRange(int nx, int ny) {
        return nx >= -5 && ny >= -5 && nx <= 5 && ny <= 5;
    }
}