package sotrh.libgdx.weeklies.snake;

import java.util.HashMap;

/**
 * author: benjamin
 * date: 3/8/16
 * project: Snake
 * package: sotrh.libgdx.weeklies.snake
 */
public class Field {
    private int size;
    private HashMap<Integer, Edibles> ediblesHashMap = new HashMap<>();

    public Field(int size) {
        this.size = size;
    }

}
