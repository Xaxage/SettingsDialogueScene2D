package com.rockbitegames.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.rockbitegames.com.ui.InputBox;
import com.rockbitegames.com.ui.ToggleButton;

public class DialogTestGame extends ApplicationAdapter {
    private Stage stage;

    @Override
    public void create() {
        ResourceManager.Get().init();
        stage = new Stage();


        SettingsDialog settingsDialog = new SettingsDialog();
        settingsDialog.setFillParent(true);

        ToggleButton toggleButton = new ToggleButton("On","Off","btn-red","btn-red-pressed");
        toggleButton.setPosition(50,50);
        toggleButton.setWidth(300);
        toggleButton.setHeight(30);


        InputBox inputBox = new InputBox("input-txt-box");
        inputBox.setPosition(50,50);
        inputBox.setWidth(300);
        inputBox.setHeight(100);


//        stage.addActor(toggleButton);
//        stage.addActor(inputBox);
        stage.addActor(settingsDialog);
        stage.setDebugAll(true);

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
