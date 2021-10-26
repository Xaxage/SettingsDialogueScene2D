package com.rockbitegames.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SettingsDialogue extends ApplicationAdapter {
	private Stage stage;
	private Skin uiSkin;
	private TextureAtlas atlas;
	private NinePatch patch;

	@Override
	public void create () {
		FileHandle atlasHandle = Gdx.files.internal("true.atlas");

		stage = new Stage();
		uiSkin = new Skin(Gdx.files.internal("uiskin.json"));
		atlas = new TextureAtlas(atlasHandle);


//To set background
		//variant 1

		Skin uiSkin = new Skin();
		uiSkin.addRegions(atlas);
		TextureRegionDrawable drawable = (TextureRegionDrawable) uiSkin.getDrawable("");

		// variant 2
//		TextureRegionDrawable drawable = new TextureRegionDrawable(atlas.findRegion("dialog-bg"));

//		TextButton textButton = new TextButton("test button", this.uiSkin);

//		Label nameLabel = new Label("Name:", this.uiSkin);
//		TextField nameText = new TextField("", this.uiSkin);
//		Label addressLabel = new Label("Address:", this.uiSkin);
//		TextField addressText = new TextField("", this.uiSkin);
		//dialog-bg
		Table rootTable = new Table();
		patch = atlas.createPatch("dialog-bg");
		NinePatchDrawable drawable1 = new NinePatchDrawable(patch);
		rootTable.setFillParent(true);
		rootTable.setBackground(drawable1);


		//dialog-inside-box
		Table innerBackgroundTable = new Table();
		patch = atlas.createPatch("dialog-inside-box");
		drawable1 = new NinePatchDrawable(patch);
		innerBackgroundTable.setBackground(drawable1);

//		//header
//		Container header = new Container();
//		patch = atlas.createPatch("header-flexible");
//		drawable1 = new NinePatchDrawable(patch);
//		header.setBackground(drawable1);
		Label nameLabel = new Label("Player Name:", );
		nameField = new InputBox();

		Table nameContainer = new Table();
		nameContainer.add(nameLabel).width(300).padLeft(30);
		nameContainer.add(nameField).growX().pad(20).height(100);
		table.add(nameContainer).pad(20).growX();





		stage.addActor(rootTable);
		rootTable.add(innerBackgroundTable).padLeft(35).padRight(35).padBottom(35).padTop(150).grow().center();


		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();

	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
