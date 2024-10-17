package structural;
// Existing interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Existing implementation
class Mp3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// New interface
interface AdvancedMediaPlayer {
    void playMp4(String fileName);
}

// New implementation
class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

// Client
public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer player = new Mp3Player();
        player.play("mp3", "song.mp3");  // Output: Playing mp3 file. Name: song.mp3

        player = new MediaAdapter("mp4");
        player.play("mp4", "video.mp4");  // Output: Playing mp4 file. Name: video.mp4
    }
}

