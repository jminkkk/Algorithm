import java.util.*;

class Solution {
    static int answer = 0;
    static int len;
    static int[][] arr;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        arr = dungeons;
        
        go(new boolean[k], 0, k, 0);
        
        return answer;
    }
    
    public void go(boolean[] visited, int depth, int nowK, int cnt) {
        if (depth == len) {
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (arr[i][0] > nowK) {
                go(visited, depth + 1, nowK - arr[i][1], cnt);
            } else {
                go(visited, depth + 1, nowK - arr[i][1], cnt + 1);
            }
            
            visited[i] = false;
        }
    }
    
}

// XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용

// "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
// "소모 피로도"는 던전을 탐험한 후 소모되는 피로도
// "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모

// 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 
// 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 
// 유저가 탐험할수 있는 최대 던전 수


