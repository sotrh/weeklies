package sotrh.java.weeklies.customsounds;

import javax.sound.sampled.LineUnavailableException;

public class Main {

    public static void main(String[] args) throws LineUnavailableException, InterruptedException {
        SoundUtils.laser(5);
        Thread.sleep(1000);
        SoundUtils.warp(10);
        Thread.sleep(1000);
        SoundUtils.bang();
    }
}
