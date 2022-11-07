package be.ucll.bombergirl.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class AnimationComponent implements Component {
    private HashMap<String, Animation<TextureRegion>> anims;

    public AnimationComponent() {
        anims = new HashMap<String, Animation<TextureRegion>>();
    }

    public AnimationComponent(HashMap<String, Animation<TextureRegion>> anims) {
        this.anims = anims;
    }

    public void putAnimation(String state, Animation<TextureRegion> anim) {
        anims.put(state, anim);
    }

    public Animation<TextureRegion> getAnimation(String state) {
        return anims.get(state);
    }

    public TextureRegion getTextureRegion(String state, float stateTime) {
        return anims.get(state).getKeyFrame(stateTime);
    }

    public TextureRegion getTextureRegion(String state, float stateTime, boolean looping) {
        return anims.get(state).getKeyFrame(stateTime, looping);
    }

}
