package sotrh.libgdx.audio.pcm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PCMAudioGame extends ApplicationAdapter {


	@Override
	public void create () {
		AudioDevice playbackDevice = Gdx.audio.newAudioDevice(44100, true);
		AudioRecorder recorder = Gdx.audio.newAudioRecorder(44100, true);

		short[] samples = new short[44100 * 10]; // 10 seconds of mono audio
		for (int i=0; i<samples.length; i++) {
			samples[i] = (short) (i % 440);
		}

		recorder.read(samples, 0, samples.length);
		playbackDevice.writeSamples(samples, 0, samples.length);
		recorder.dispose();
		playbackDevice.dispose();
		Gdx.app.exit();
	}

	@Override
	public void dispose() {

	}
}
