import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        // 1. 가장 많이 재생된 장르
        Map<String, Integer> totalCnt = new HashMap<>();
        
        // 2. 장르별 재생 노래
        Map<String, PriorityQueue<Music>> playsByGenre = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            int playCnt = plays[i];
            
            int newSum =  totalCnt.getOrDefault(genre, 0) + playCnt;
            totalCnt.put(genre, newSum);
            
            PriorityQueue<Music> pq = playsByGenre.getOrDefault(genre, new PriorityQueue<>());
            Music newMusic = new Music(i, playCnt);
            pq.add(newMusic);
            playsByGenre.put(genre, pq);
        }

        PriorityQueue<Genre> genrePq = new PriorityQueue<>();
        for (String key : totalCnt.keySet()) {
            Genre genre = new Genre(key, totalCnt.get(key));
            genrePq.add(genre);
        }
        
        
        List<Integer> idx = new ArrayList<>();
        while (!genrePq.isEmpty()) {
            Genre genre = genrePq.poll();
            PriorityQueue<Music> pq = playsByGenre.get(genre.name);
            
            if (!pq.isEmpty()) {
                Music music = pq.poll();
                idx.add(music.idx); 
            }
            if (!pq.isEmpty()) {
                Music music = pq.poll();
                idx.add(music.idx); 
            }
        }
        
        int[] answer = idx.stream().mapToInt(i -> i).toArray();

        return answer;
    }
    
}

class Genre implements Comparable<Genre> {
    String name;
    int sum;
    
    Genre(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }
    
    public int compareTo(Genre o) {        
        return Integer.compare(o.sum, this.sum);
    }
}

class Music implements Comparable<Music> {
    int idx;
    int cnt;
    
    Music(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
    
    public int compareTo(Music o) {
        if (this.cnt == o.cnt) return Integer.compare(this.idx, o.idx);
        
        return Integer.compare(o.cnt, this.cnt);
    }
}