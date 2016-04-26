package sotrh.java.weeklies.customsounds;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.util.Random;

/**
 * author: benjamin
 * date: 4/24/16
 * project: CustomSounds
 * package: sotrh.java.weeklies.customsounds
 */
public class SoundUtils {
    public static final float SAMPLE_RATE = 8000f;
    public static final AudioFormat AUDIO_FORMAT = new AudioFormat(
            SAMPLE_RATE, // sample rate
            8,           // sample size in bytes
            1,           // channels
            true,        // signed
            false        // big endian
    );


    public static void laser(int repeat) throws LineUnavailableException, InterruptedException {
        SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(AUDIO_FORMAT);
        sourceDataLine.open(AUDIO_FORMAT);
        sourceDataLine.start();

        byte[] buffer = new byte[1];
        int step;

        for (int j=0; j<repeat; j++) {
            step = 10;
            for (int i=0; i<2000; i++) {
                buffer[0] = ((i%step > 0) ? 32 : (byte)0);
                if (i%250 == 0) step += 2;
                sourceDataLine.write(buffer, 0, 1);
            }
            Thread.sleep(200);
        }
        sourceDataLine.drain();
        sourceDataLine.stop();
        sourceDataLine.close();
    }

    public static void warp(int repeat) throws LineUnavailableException, InterruptedException {
        SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(AUDIO_FORMAT);
        sourceDataLine.open(AUDIO_FORMAT);
        sourceDataLine.start();

        byte[] buffer = new byte[1];
        int step;

        for (int j=0; j<repeat; j++) {
            step = 10;
            for (int i=0; i<2000; i++) {
                if (i < 200) {
                    buffer[0] = i%step > 0 ? 32 : (byte)0;
                    if (i%25 == 0) step--;
                }
                else {
                    buffer[0] = i%step > 0 ? 16 : (byte)0;
                    if (i%50 == 0) step++;
                }
                sourceDataLine.write(buffer, 0, 1);
            }
        }
        sourceDataLine.drain();
        sourceDataLine.stop();
        sourceDataLine.close();
    }

    public static void bang() throws LineUnavailableException {
        SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(AUDIO_FORMAT);
        sourceDataLine.open(AUDIO_FORMAT);
        sourceDataLine.start();

        byte[] buffer = new byte[1];
        Random random = new Random();
        boolean silence = true;

        for (int i=0; i<8000; i++) {
            while (random.nextInt() % 10 != 0) {
                buffer[0] =
                        silence ? 0 :
                                (byte)Math.abs(random.nextInt() %
                                        (int)(1. + 63. * (1. + Math.cos(((double)i)
                                        * Math.PI / 8000))));
                i++;
                sourceDataLine.write(buffer, 0, 1);
             }
            silence = !silence;
        }

        sourceDataLine.drain();
        sourceDataLine.stop();
        sourceDataLine.close();
    }
}
