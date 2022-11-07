package be.ucll.bombergirl.systems;

import be.ucll.bombergirl.components.StateComponent;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class StateSystem extends IteratingSystem {
    private final ComponentMapper<StateComponent> stateComponentMapper;

    public StateSystem() {
        super(Family.all(StateComponent.class).get());

        stateComponentMapper = ComponentMapper.getFor(StateComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        stateComponentMapper.get(entity).addStateTime(deltaTime);
    }
}