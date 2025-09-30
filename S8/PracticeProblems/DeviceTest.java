public class DeviceTest {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.takePhoto();
        sp.playMusic();
    }
}

interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

class SmartPhone implements Camera, MusicPlayer {
    public void takePhoto() {
        System.out.println("Taking photo with smartphone");
    }
    public void playMusic() {
        System.out.println("Playing music on smartphone");
    }
}
