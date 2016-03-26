package sotrh.libgdx.weeklies.runner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * author: benjamin
 * date: 3/20/16
 * project: Runner
 * package: sotrh.libgdx.weeklies.runner
 */
public class GameScreen implements Screen {
    public static final float PIXELS_TO_METERS = 200f;
    public static final float GROUND_HEIGHT = 0.3f;
    public static final float PLAYER_SIZE = .4f;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;

    private Player player;

    private float width;
    private float height;

    @Override
    public void show() {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        texture = new Texture(pixmap);
        pixmap.dispose();

        width = Gdx.graphics.getWidth() / PIXELS_TO_METERS;
        height = Gdx.graphics.getHeight() / PIXELS_TO_METERS;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        batch = new SpriteBatch();

        player = new Player(new Rectangle(PLAYER_SIZE, GROUND_HEIGHT, PLAYER_SIZE, PLAYER_SIZE));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        processInput();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        drawGround();
        drawPlayer();
        batch.end();
    }

    private void processInput() {
    }

    private void drawGround() {
        batch.draw(texture, 0, 0, width, GROUND_HEIGHT);
    }

    private void drawPlayer() {
        batch.draw(texture, player.body.x, player.body.y, player.body.width, player.body.height);
    }

    @Override
    public void resize(int width, int height) {
        this.width = width / PIXELS_TO_METERS;
        this.height = height / PIXELS_TO_METERS;
        camera.setToOrtho(false, this.width, this.height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
