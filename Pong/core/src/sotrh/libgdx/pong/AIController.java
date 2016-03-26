package sotrh.libgdx.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

/**
 * author: benjamin
 * date: 2/29/16
 * project: Pong
 * package: sotrh.libgdx.pong
 */
public class AIController extends Controller {
    private final Ball ball;

    public AIController(Player player, Ball ball) {
        super(player);
        this.ball = ball;
    }

    @Override
    public void processInput(float delta) {
        float height = getPlayer().body.height;

//        if (ball.position.y > getPlayer().body.y + height / 2)
//            getPlayer().body.y += SPEED * delta * MathUtils.random();
//        if (ball.position.y < getPlayer().body.y + height / 2)
//            getPlayer().body.y -= SPEED * delta * MathUtils.random();

        // Normalize the player
        float maxHeight = Gdx.graphics.getHeight() / 2 - height;
        float minHeight = -Gdx.graphics.getHeight() / 2;
        if (getPlayer().body.y > maxHeight) getPlayer().body.y = maxHeight;
        if (getPlayer().body.y < minHeight) getPlayer().body.y = minHeight;
    }
}
