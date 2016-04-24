package sotrh.libgdx.ashleyrunner.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sotrh.libgdx.ashleyrunner.entities.components.PositionComponent;
import sotrh.libgdx.ashleyrunner.entities.components.RenderableComponent;

import java.util.Comparator;

/**
 * author: benjamin
 * date: 4/14/16
 * project: AshleyRunner
 * package: sotrh.libgdx.ashleyrunner
 */
public class RenderSystem extends SortedIteratingSystem {
    private static ComponentMapper<RenderableComponent> rm;
    private static ComponentMapper<PositionComponent> pm;

    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;

    public RenderSystem(SpriteBatch spriteBatch) {
        super(
                Family.all(RenderableComponent.class, PositionComponent.class).get(),
                new ZComparator()
        );
        this.spriteBatch = spriteBatch;
        this.camera = new OrthographicCamera();

        rm = ComponentMapper.getFor(RenderableComponent.class);
        pm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    public void update(float deltaTime) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        super.update(deltaTime);
        spriteBatch.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        RenderableComponent r = rm.get(entity);
        PositionComponent p = pm.get(entity);
        spriteBatch.draw(r.texture, p.x, p.y);
    }

    private static class ZComparator implements Comparator<Entity> {
        @Override
        public int compare(Entity a, Entity b) {
            return (int) Math.signum(pm.get(a).z - pm.get(b).z);
        }
    }
}
