package sotrh.libgdx.ashleyrunner.entities.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import sotrh.libgdx.ashleyrunner.entities.components.PositionComponent;

/**
 * author: benjamin
 * date: 4/24/16
 * project: AshleyRunner
 * package: sotrh.libgdx.ashleyrunner.entities.systems
 */
public class MovementSystem extends IteratingSystem {

    public MovementSystem() {
        super(
                Family.all(PositionComponent.class).get()
        );
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
