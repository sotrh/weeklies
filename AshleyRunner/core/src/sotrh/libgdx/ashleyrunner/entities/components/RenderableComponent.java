package sotrh.libgdx.ashleyrunner.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

/**
 * author: benjamin
 * date: 4/14/16
 * project: AshleyRunner
 * package: sotrh.libgdx.ashleyrunner.entities
 */
public class RenderableComponent implements Component {
    public Texture texture;

    public RenderableComponent(Texture texture) {
        this.texture = texture;
    }
}
