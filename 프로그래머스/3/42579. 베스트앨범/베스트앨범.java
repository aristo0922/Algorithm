import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> infoPlays = new HashMap<>();
    static int[] playNums;

    public static int[] solution(String[] genres, int[] plays) {
        playNums = plays;
        ArrayList<Integer> sol = new ArrayList<>();

        // 장르별로 노래들의 인덱스를 저장
        matchGenre(genres);

        // 장르별 재생 횟수 합산 및 정렬
        ArrayList<String> sortedGenre = initGenres(genres, plays);

        // 각 장르별로 재생 횟수 상위 2곡 선택
        for (String genre : sortedGenre) {
            List<Integer> songList = infoPlays.get(genre);

            // 재생 횟수 기준으로 내림차순 정렬
            Collections.sort(songList, (a, b) -> {
                if (playNums[b] == playNums[a]) {
                    return a - b; // 재생 횟수가 같으면 고유 번호 기준 오름차순
                }
                return playNums[b] - playNums[a]; // 재생 횟수 기준 내림차순
            });

            // 상위 2곡 선택
            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                sol.add(songList.get(i));
            }
        }

        return sol.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void matchGenre(String[] genres) {
        for (int i = 0; i < genres.length; i++) {
            infoPlays.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }
    }

    public static ArrayList<String> initGenres(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a)); // 장르별 재생 횟수 기준 내림차순 정렬

        return sortedGenres;
    }
}
