package com.rockbitegames.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class DialogTestGame extends ApplicationAdapter {
    private Stage stage;

    @Override
    public void create() {
        ResourceManager.Get().init();
        stage = new Stage();


        SettingsDialog settingsDialog = new SettingsDialog();
        settingsDialog.setFillParent(true);


        stage.addActor(settingsDialog);
//        stage.setDebugAll(true);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
