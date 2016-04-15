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
    private Edibles[] matrix;

    public Field(int size) {
        this.size = size;
        matrix = new Edibles[size * size];
    }

    Edibles get(int cell) {
        if (cell < 0 || cell >= size * size) return Edibles.WALL;
        return matrix[cell];
    }

    Edibles get(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return Edibles.WALL;
        return get(x + y * size);
    }
}
