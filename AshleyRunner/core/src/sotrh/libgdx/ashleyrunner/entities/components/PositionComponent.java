package sotrh.libgdx.ashleyrunner.entities.components;

import com.badlogic.ashley.core.Component;

/**
 * author: benjamin
 * date: 4/14/16
 * project: AshleyRunner
 * package: sotrh.libgdx.ashleyrunner.entities.components
 */
public class PositionComponent implements Component {
    public float x = 0;
    public float y = 0;
    public float z = 0;

    public PositionComponent(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
