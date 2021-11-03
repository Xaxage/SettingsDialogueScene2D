package com.rockbitegames.com.screen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rockbitegames.com.DialogTestGame;
import com.rockbitegames.com.ResourceManager;

public class LoadingScreen extends ApplicationAdapter implements Screen {


    private final AssetManager assetManager;

    private Game game;
    private OrthographicCamera camera;
    private Viewport viewport;

    private SpriteBatch batch;
    private ShapeRenderer renderer;
    private Sprite screenBg;
    private TextureAtlas atlas;


    private float timerBuffer;
    private float progress;


    public LoadingScreen(Game game) {
        this.game = game;
        this.assetManager = ResourceManager.Get().getAssetManager();
        this.progress = 0f;
        queueAssets();
    }

    @Override
    public void show() {

        camera = new OrthographicCamera();
        viewport = new FitViewport(1280 / 3f, 720, camera);
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
        FileHandle atlasHandle = new FileHandle("splashscreen/splashScreen.atlas");
        atlas = new TextureAtlas(atlasHandle);

        screenBg = atlas.createSprite("screen-bg");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);

        camera.update();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();


        batch.end();

        drawProgressBar();
        drawProgress();

        update(delta);
    }

    public void update(float delta) {//Probably it'll be in a ResourceManager
        progress = MathUtils.lerp(progress, assetManager.getProgress(), .1f);
        if (assetManager.update() && timerBuffer > 1) {//It'll return false until al resources are loaded
            game.setScreen(new DialogTestGame());
        } else {
            timerBuffer += delta;
        }
    }

    private void queueAssets() {
        //Already done in ResourceManager
    }


    private void draw() {
        batch.draw(screenBg, 0, 0, viewport.getScreenWidth(), viewport.getScreenHeight());
    }

    private void drawProgressBar() {
//        batch.draw(new Texture("raw_assets/empty-bar.png"), 20, 40, viewport.getScreenWidth() - 40, 70);
//        batch.draw(new Texture("raw_assets/filled.png"), -90, 30, 500, 85);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.BLACK);

        renderer.rect(20, 40, viewport.getScreenWidth() - 40, 50);
        renderer.end();
    }

    private void drawProgress() {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.YELLOW);

        renderer.rect(21, 41, progress * (viewport.getScreenWidth() - 43), 47); //21,41,screenWidth-40(is a max),47
        renderer.end();
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        renderer.dispose();
        assetManager.dispose();
    }
}
