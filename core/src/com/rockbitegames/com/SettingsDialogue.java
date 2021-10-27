package com.rockbitegames.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SettingsDialogue extends ApplicationAdapter {
    private Stage stage;
    private Skin uiSkin;
    private TextureAtlas atlas;
    private NinePatch patch;
    private FileHandle atlasHandle;

    @Override
    public void create() {

        //Init
        atlasHandle = Gdx.files.internal("true.atlas");
        stage = new Stage(new ScreenViewport());
        atlas = new TextureAtlas(atlasHandle);
//		uiSkin = new Skin(Gdx.files.internal("uiskin.json"));
//		Skin uiSkin = new Skin();
//		uiSkin.addRegions(atlas);
//		TextureRegionDrawable drawable = (TextureRegionDrawable) uiSkin.getDrawable("uiskin.json");

        //Style and font segments
        BitmapFont fnt = new BitmapFont(Gdx.files.internal("font.fnt"));
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        labelStyle.font = fnt;
        textFieldStyle.font = fnt;
        textFieldStyle.focusedFontColor = Color.WHITE;
        textFieldStyle.disabledFontColor = Color.WHITE;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.messageFontColor = Color.WHITE;



        //Creating blank table
        final Table container = new Table();
        container.setFillParent(true);



        //Creating content table
        patch = atlas.createPatch("dialog-bg");
        NinePatchDrawable drawable = new NinePatchDrawable(patch);

        Table content = new Table();
        content.pad(15);

        content.setBackground(drawable);
        content.top();
        container.add(content).grow();//.pad(50);



        //Creating header
        patch = atlas.createPatch("header-flexible");
        drawable = new NinePatchDrawable(patch);

        Table headerTable = new Table();
        headerTable.top();

        Label settingsLabel = new Label("Settings",labelStyle);
//        settingsLabel.setFontScale(2f);//Very bad choice
        headerTable.add(settingsLabel);
        headerTable.setBackground(drawable);



        //Creating dialog-inside-box and adding it
        patch = atlas.createPatch("dialog-inside-box");
        drawable = new NinePatchDrawable(patch);

        Table innerBackgroundTable = new Table();
        innerBackgroundTable.setBackground(drawable);
        innerBackgroundTable.top().left();//When we say table.top() it'll any item we add will start from the top


        //Creating name table and adding it

        Label nameLabel = new Label("Player Name:", labelStyle);
//        nameLabel.setFontScale(0.75f);
        nameLabel.setAlignment(Align.left);
        nameLabel.setEllipsis(true);

        TextField textField = new TextField("", textFieldStyle);

        //Giving textField it's background
        patch = atlas.createPatch("input-txt-box");
        drawable = new NinePatchDrawable(patch);
//        textFieldStyle.background =  drawable;

        final Table textFieldWrapper = new Table();
        textFieldWrapper.background(drawable);
        textFieldWrapper.add(textField).pad(10);

        Table nameTable = new Table();
        nameTable.pad(15);
        nameTable.defaults().space(10); //Space between call the components
        nameTable.add(nameLabel).width(120).expandX().left();
        nameTable.add(textFieldWrapper).expandX().right();//.width(180);

        // Adding content
        content.add(headerTable).growX().padLeft(65).padRight(65).height(50);
        content.row();
        content.add(innerBackgroundTable).pad(20).grow();
        content.row();

//		nameLabel.setAlignment(Align.topLeft);//TO set start position in its own regions
//		nameTable.add(testLabel);
//		nameTable.add(textField);
//		nameTable.pad(20); //Is to pad the whole table

        //Debug section
        container.debugAll();

        innerBackgroundTable.add(nameTable).growX();
//        table.pad - margin in android
//                cell.pad - true pad
        stage.addActor(container);
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
