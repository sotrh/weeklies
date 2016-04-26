package sotrh.libgdx.weeklies.box2d;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Box2dGame extends Game {

	@Override
	public void create() {
		setScreen(new PlayScreen());
	}
}
