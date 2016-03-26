package sotrh.libgdx.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * author: benjamin
 * date: 2/29/16
 * project: Pong
 * package: sotrh.libgdx.pong
 */
public class Ball {
    public float radius;
    public Color color = Color.WHITE;
    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2();

    public Ball(float radius) {
        this.radius = radius;
    }

    public Ball(float radius, Vector2 position, Vector2 velocity) {
        this(radius);
        this.position = position;
        this.velocity = velocity;
    }
}
