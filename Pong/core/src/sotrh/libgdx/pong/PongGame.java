package sotrh.libgdx.pong;

import com.badlogic.gdx.Game;

public class PongGame extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
