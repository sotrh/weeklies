package sotrh.libgdx.weeklies.runner;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * author: benjamin
 * date: 3/20/16
 * project: Runner
 * package: sotrh.libgdx.weeklies.runner
 */
public class Player {
    public Rectangle body;
    public Vector2 velocity = new Vector2();

    public Player(Rectangle body) {
        this.body = body;
    }
}
