package sotrh.libgdx.weeklies.runner;

import com.badlogic.gdx.Game;

public class RunnerGame extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
