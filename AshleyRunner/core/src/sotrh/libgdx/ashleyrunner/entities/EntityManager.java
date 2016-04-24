package sotrh.libgdx.ashleyrunner.entities;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sotrh.libgdx.ashleyrunner.entities.systems.RenderSystem;

/**
 * author: benjamin
 * date: 4/14/16
 * project: AshleyRunner
 * package: sotrh.libgdx.ashleyrunner
 */
public class EntityManager {

    private PooledEngine engine;

    public EntityManager() {
        engine = new PooledEngine();
    }

    public void update() { engine.update((float) Gdx.graphics.getDeltaTime()); }

    public void clearPools() { engine.clearPools(); }

    public void addRenderSystem(SpriteBatch batch) {
        engine.addSystem(new RenderSystem(batch));
    }
}
