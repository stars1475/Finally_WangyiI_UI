package music_search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicSearch {

    public static List<Music> musicSearch(String query) throws IOException {
        List<Music> allMusicInfo = MusicLoader.loadAllMusicInfo();

        List<Music> searchResult = new ArrayList<Music>();
        for (Music music : allMusicInfo) {
            String name = music.getName();
            if (query.equals(name)) {
                searchResult.add(music);
            }
        }

        return searchResult;
    }
}
