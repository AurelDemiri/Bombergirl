package be.ucll.bombergirl.builders;

import be.ucll.bombergirl.components.AnimationComponent;
import be.ucll.bombergirl.components.TransformComponent;
import be.ucll.bombergirl.entities.PlayerEntity;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

public class PlayerBuilder {
    private static PlayerBuilder instance;

    public static PlayerBuilder getInstance() {
        if (instance == null)
             instance = new PlayerBuilder();

        return instance;
    }

    public static void createPlayer(Engine engine, float x, float y) {
        // animation
        HashMap<String, Animation<TextureRegion>> anims = new HashMap<>();
        Animation<TextureRegion> anim;

        Array<TextureRegion> keyFrames = new Array<>();

        // walking up
        for (int i = 0; i < 3; i++) {
            keyFrames.add(new TextureRegion(textureRegion, i * 16, 0, 16, 24));
        }
        anim = new Animation<>(0.1f, keyFrames, Animation.PlayMode.LOOP);
        anims.put("walking_up", anim);

        //Renderer renderer = new Renderer(new TextureRegion(textureRegion, 0, 0, 16, 24), 16 / GameManager.PPM, 24 / GameManager.PPM);
        //renderer.setOrigin(16 / GameManager.PPM / 2, 16 / GameManager.PPM / 2);

        /* entity
        Entity e = new com.artemis.utils.EntityBuilder(world)
                .with(
                        new Player(resetPlayerAbilities),
                        new Transform(x, y, 1, 1, 0),
                        new RigidBody(body),
                        new State("idling_down"),
                        renderer,
                        new Anim(anims)
                )
                .build();
         */

        PlayerEntity player = (PlayerEntity) engine.createEntity();

        TransformComponent transformComponent = engine.createComponent(TransformComponent.class);
        transformComponent.position = new Vector2(16, 16);
        AnimationComponent animationComponent = new AnimationComponent(anims);



        engine.addEntity(player);
    }
}
