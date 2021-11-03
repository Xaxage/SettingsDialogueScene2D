package com.rockbitegames.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class DialogTestGame implements Screen {
    private Stage stage;

    public DialogTestGame() {

    }


    @Override
    public void show() {
        stage = new Stage();

        SettingsDialog settingsDialog = new SettingsDialog();
        settingsDialog.setFillParent(true);

        stage.addActor(settingsDialog);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        stage.dispose();
    }
}
