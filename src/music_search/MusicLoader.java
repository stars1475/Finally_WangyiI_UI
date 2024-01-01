package music_search;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.Files.readAttributes;

public class MusicLoader {
    public static List<Music> loadAllMusicInfo() throws IOException {
        String path = "resources/music";
        File file = new File(path);
        List<Music> list = new ArrayList<>();
        if (file.isDirectory()) {
            String[] fileNames = file.list();
            if (fileNames != null) {
                for (String fileName : fileNames) {
                    String musicPath = path + fileName;
                    //System.out.println(musicPath);
                    File musicFile = readMusicFile(musicPath);
                    BasicFileAttributes attrs = readAttributes(musicFile.toPath(), BasicFileAttributes.class);
                    String musicName = fileName.split("\\.")[0];
                    String time = String.valueOf(attrs.size());
                    String modifyTime = String.valueOf(attrs.lastModifiedTime());
                    Music music = new Music();
                    music.setTime(time);
                    music.setTime(time);
                    music.setModifyTime(modifyTime);
                    music.setName(fileName);
                    list.add(music);
                }
            }
        }
        return list;

    }

    public static File readMusicFile(String path) {
        File file = new File(path);
        return file;
    }

    public static void main(String[] args) throws IOException {
        List<Music> list = MusicLoader.loadAllMusicInfo();
        System.out.println(list);
    }
}
