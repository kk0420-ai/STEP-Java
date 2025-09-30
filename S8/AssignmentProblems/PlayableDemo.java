interface Playable {
    void play();
    void pause();
}

class MusicPlayer implements Playable {
    public void play() { System.out.println("Music Playing"); }
    public void pause() { System.out.println("Music Paused"); }
}

class VideoPlayer implements Playable {
    public void play() { System.out.println("Video Playing"); }
    public void pause() { System.out.println("Video Paused"); }
}

public class PlayableDemo {
    public static void main(String[] args) {
        Playable p = new MusicPlayer();
        p.play();
        p.pause();
        p = new VideoPlayer();
        p.play();
        p.pause();
    }
}
