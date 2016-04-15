package sotrh.libgdx.runner;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * author: benjamin
 * date: 4/14/16
 * project: Runner
 * package: sotrh.libgdx.runner
 */
public class GameWorld {
    public static final float WORLD_TO_BOX = 0.01f;
    public static final float BOX_TO_WORLD = 100.f;
    public static final Vector2 GRAVITY = new Vector2(0, -20);

    public static float convertToBox(float x) { return x * WORLD_TO_BOX; }

    private World world;

    public GameWorld() {
        world = new World(GRAVITY, true);
    }

}
