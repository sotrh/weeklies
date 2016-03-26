package sotrh.libgdx.pong;

/**
 * author: benjamin
 * date: 2/29/16
 * project: Pong
 * package: sotrh.libgdx.pong
 */
public abstract class Controller {
    public static final int SPEED = 500;

    private final Player player;

    public Controller(Player player) {
        this.player = player;
    }

    public abstract void processInput(float delta);

    public Player getPlayer() {
        return player;
    }
}
