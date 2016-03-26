package sotrh.libgdx.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

/**
 * author: benjamin
 * date: 2/27/16
 * project: Pong
 * package: sotrh.libgdx.pong
 */
public class Player {
    public Rectangle body = new Rectangle();
    public Color color = Color.WHITE;
    public int score;

    public Player(Rectangle body, Color color) {
        this.body = body;
        this.color = color;
    }

    public void score() {
        this.score++;
    }
}
