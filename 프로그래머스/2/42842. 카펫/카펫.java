import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 가로가 무조건 길다.
        int nubi = yellow + brown;
        
        for (int i = 2; i <= Math.sqrt(nubi); i++) {
            if (nubi % i == 0) {
                System.out.println(i);
                if (check(i, nubi / i, brown, yellow)) {
                    answer[0] = nubi / i;
                    answer[1] = i;
            }
        }
        
        }
        return answer;
    }
    // index가 무조건 작음 = 세로
        public boolean check(int y, int x, int brown, int yellow) {
        int nubi = brown + yellow;
        
        // yellow의 가로 세로 구함
        int yellowX = x - 2;
        int yellowY = y - 2;
        int yellowNubi = yellowX * yellowY;
        
        if ((yellowNubi == yellow) && (nubi - yellowNubi == brown)) {
            return true;
        }
        else return false;
    }
}