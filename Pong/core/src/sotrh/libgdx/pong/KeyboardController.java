package sotrh.libgdx.pong;

import com.badlogic.gdx.Gdx;

/**
 * author: benjamin
 * date: 2/29/16
 * project: Pong
 * package: sotrh.libgdx.pong
 */
public class KeyboardController extends Controller {
    private final int upKey;
    private final int downKey;

    public KeyboardController(Player player, int upKey, int downKey) {
        super(player);
        this.upKey = upKey;
        this.downKey = downKey;
    }

    @Override
    public void processInput(float delta) {
        if (Gdx.input.isKeyPressed(upKey)) getPlayer().body.y += SPEED * delta;
        if (Gdx.input.isKeyPressed(downKey)) getPlayer().body.y -= SPEED * delta;

        float maxHeight = Gdx.graphics.getHeight() / 2 - getPlayer().body.height;
        float minHeight = -Gdx.graphics.getHeight() / 2;
        if (getPlayer().body.y > maxHeight) getPlayer().body.y = maxHeight;
        if (getPlayer().body.y < minHeight) getPlayer().body.y = minHeight;
    }
}
