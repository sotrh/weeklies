package sotrh.libgdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

/**
 * author: benjamin
 * date: 2/27/16
 * project: Pong
 * package: sotrh.libgdx.pong
 */
public class GameScreen implements Screen {
    private Texture texture;
    private BitmapFont font;
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private Player player1;

    private Player player2;
    private Controller controller1;

    private Controller controller2;
    private Ball ball;

    public GameScreen() {
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA4444);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        texture = new Texture(pixmap);
        pixmap.dispose();

        // Create the players
        float radius = Gdx.graphics.getHeight() / 2;
        player1 = new Player(new Rectangle(-radius-20, -50, 20, 100), Color.CYAN);
        player2 = new Player(new Rectangle(radius, -50, 20, 100), Color.ORANGE);

        // Create the ball
        ball = new Ball(10);

        // Setup input controllers
        controller1 = new KeyboardController(player1, Input.Keys.W, Input.Keys.S);
        controller2 = new KeyboardController(player2, Input.Keys.UP, Input.Keys.DOWN);
        setBall();

        // Setup text
        font = new BitmapFont();
    }

    private void setBall() {
        float width = Gdx.graphics.getWidth() / 2;
        if (ball.position.x > width) player1.score();
        if (ball.position.x < -width) player2.score();

        ball.position.x = 0;
        ball.position.y = 0;

        // Give the ball a random direction
        float theta = MathUtils.PI2 * MathUtils.random();
        ball.velocity.x = 100 * MathUtils.cos(theta);
        ball.velocity.y = 100 * MathUtils.sin(theta);
        ball.color = Color.WHITE;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        processInput(delta);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        drawBall(ball);
        drawPlayer(player1);
        drawPlayer(player2);
        drawScore();
        batch.end();
    }

    private void drawScore() {
        float x = 10 - Gdx.graphics.getWidth() / 2;
        float y = Gdx.graphics.getHeight() / 2 - 10;
        font.draw(batch, player1.score + " - " + player2.score, x, y);
    }

    private void processInput(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
            return;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
        {
            setBall();
        }

        updateBall(delta);
        bounce(delta, player1);
        bounce(delta, player2);

        controller1.processInput(delta);
        controller2.processInput(delta);
    }

    private void updateBall(float delta) {
        float height = Gdx.graphics.getHeight() / 2;
        ball.position.x += ball.velocity.x * delta;
        ball.position.y += ball.velocity.y * delta;
        if (ball.position.y > height) {
            ball.position.y = height;
            ball.velocity.y *= -1;
        }
        if (ball.position.y < -height) {
            ball.position.y = -height;
            ball.velocity.y *= -1;
        }
        float width = Gdx.graphics.getWidth() / 2;
        if (ball.position.x < -width || ball.position.x > width) setBall();
    }

    private void bounce(float delta, Player player) {
        if (player.body.contains(ball.position)) {
            ball.position.x -= ball.velocity.x * delta;
            ball.velocity.x *= -1;
            ball.color = player.color;
        }
    }

    private void drawPlayer(Player player) {
        batch.setColor(player.color);
        batch.draw(texture, player.body.x, player.body.y, player.body.width, player.body.height);
    }

    private void drawBall(Ball ball) {
        float radius = ball.radius;
        float x = ball.position.x - radius;
        float y = ball.position.y - radius;
        batch.setColor(ball.color);
        batch.draw(texture, x, y, radius*2, radius*2);
    }

    @Override
    public void resize(int width, int height) {

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
        batch.dispose();
        texture.dispose();
    }
}
