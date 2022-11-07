package be.ucll.bombergirl.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class RendererComponent implements Component {
    private final Sprite sprite;
    private int z = 0;

    public RendererComponent(TextureRegion textureRegion) {
        sprite = new Sprite(textureRegion);
    }

    public RendererComponent(TextureRegion textureRegion, float width, float height) {
        this(textureRegion);
        sprite.setSize(width, height);
    }

    public void setRegion(TextureRegion textureRegion) {
        sprite.setRegion(textureRegion);
    }

    public void setOrigin(float x, float y) {
        sprite.setOrigin(x, y);
    }

    public void setOrigin(Vector2 pos) {
        sprite.setOrigin(pos.x, pos.y);
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x - sprite.getOriginX(), y - sprite.getOriginY());
    }

    public void setRotation(float degrees) {
        sprite.setRotation(degrees);
    }

    public void setScale(float x, float y) {
        sprite.setScale(x, y);
    }

    public int getZ() {
        return z;
    }

    public void setZ(int zOrder) {
        z = zOrder;
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
