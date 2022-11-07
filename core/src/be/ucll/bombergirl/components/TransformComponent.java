package be.ucll.bombergirl.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent implements Component{
    public Vector2 position;
    public Vector2 scale;
    public float rotation;

    public TransformComponent(Vector2 position, Vector2 scale, float rotation) {
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }

    public TransformComponent() {
        this(Vector2.Zero, new Vector2(1, 1),0);
    }
}