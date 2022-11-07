package be.ucll.bombergirl;

import be.ucll.bombergirl.systems.RenderSystem;
import be.ucll.bombergirl.systems.StateSystem;
import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class MyGame extends Game {
    private SpriteBatch batch;
    private TiledMapRenderer tiledMapRenderer;
    private Engine engine;
    private World world;
    private RenderSystem renderSys;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(240, 208);

        TiledMap tiledMap = new TmxMapLoader().load("map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        batch = new SpriteBatch();

        engine = new Engine();
        renderSys = new RenderSystem(batch);
        engine.addSystem(renderSys);
        engine.addSystem(new StateSystem());

        world = new World(Vector2.Zero, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tiledMapRenderer.setView(renderSys.getCamera());
        tiledMapRenderer.render();

        engine.update(Gdx.graphics.getDeltaTime());

        world.step(1 / 60.0f, 8, 3);
    }

    @Override
    public void dispose() {
        batch.dispose();
		//TODO: proper disposing
    }
}
