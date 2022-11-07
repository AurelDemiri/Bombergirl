package be.ucll.bombergirl.systems;

import be.ucll.bombergirl.components.RendererComponent;
import be.ucll.bombergirl.components.TransformComponent;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Comparator;

public class RenderSystem extends SortedIteratingSystem {
    private static final ComponentMapper<TransformComponent> transformComponentMapper =
            ComponentMapper.getFor(TransformComponent.class);
    private static final ComponentMapper<RendererComponent> rendererComponentMapper =
            ComponentMapper.getFor(RendererComponent.class);
    private final SpriteBatch batch;
    private final OrthographicCamera camera;

    public RenderSystem(SpriteBatch spriteBatch) {
        super(Family.all(TransformComponent.class, RendererComponent.class).get(), new ZComparator());

        batch = spriteBatch;

        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        camera.update();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for (Entity entity : getEntities()) {
            RendererComponent rendererComponent = rendererComponentMapper.get(entity);
            TransformComponent transformComponent = transformComponentMapper.get(entity);

            rendererComponent.setOrigin(transformComponent.position);
            rendererComponent.draw(batch);
        }

        batch.end();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
    }

    private static class ZComparator implements Comparator<Entity> {
        @Override
        public int compare(Entity entityA, Entity entityB) {
            return (int)Math.signum(
                    rendererComponentMapper.get(entityA).getZ() - rendererComponentMapper.get(entityB).getZ());
        }
    }
}
