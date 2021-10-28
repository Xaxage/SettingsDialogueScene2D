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
import com.badlogic.gdx.utils.Align;

import com.rockbitegames.com.ui_staff.MyTextButton;

public class SettingsDialogue extends ApplicationAdapter {
    private Stage stage;
    private Skin uiSkin;
    private TextureAtlas atlas;
    private NinePatch patch;
    private FileHandle atlasHandle;
    private NinePatchDrawable ninePatchDrawable;

    @Override
    public void create() {

        //Init
        atlasHandle = Gdx.files.internal("true.atlas");
        stage = new Stage();
        atlas = new TextureAtlas(atlasHandle);
//		uiSkin = new Skin(Gdx.files.internal("uiskin.json"));
//		Skin uiSkin = new Skin();
//		uiSkin.addRegions(atlas);
//		TextureRegionDrawable drawable = (TextureRegionDrawable) uiSkin.getDrawable("uiskin.json");

        //Style and font segments

        BitmapFont fnt = new BitmapFont(Gdx.files.internal("font.fnt"));
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = fnt;

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = fnt;
        textButtonStyle.fontColor = Color.WHITE;

        ImageButton.ImageButtonStyle imageButtonStyle = new ImageButton.ImageButtonStyle();



        ImageTextButton.ImageTextButtonStyle imageTextButtonStyle = new ImageTextButton.ImageTextButtonStyle();
        imageTextButtonStyle.font = fnt;
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = fnt;
        textFieldStyle.focusedFontColor = Color.WHITE;
        textFieldStyle.disabledFontColor = Color.WHITE;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.messageFontColor = Color.WHITE;



        //Creating blank table (backstage)
        Table container = new Table();
        container.setFillParent(true);



        //Creating content table and adding it to  container
        patch = atlas.createPatch("dialog-bg");
        ninePatchDrawable = new NinePatchDrawable(patch);

        Table content = new Table();
        content.pad(15);

        content.setBackground(ninePatchDrawable);
        content.top();

        container.add(content).grow();//.pad(50);



        //Creating header and adding it to content
        patch = atlas.createPatch("header-flexible");
        ninePatchDrawable = new NinePatchDrawable(patch);

        Table headerTable = new Table();
        headerTable.top();

        Label settingsLabel = new Label("Settings", labelStyle);
        headerTable.add(settingsLabel);
        headerTable.setBackground(ninePatchDrawable);

        content.add(headerTable).growX().padLeft(65).padRight(65).height(50);
        content.row();



        //Creating innerBackgroundTable and adding it to content
        patch = atlas.createPatch("dialog-inside-box");
        ninePatchDrawable = new NinePatchDrawable(patch);

        Table innerBackgroundTable = new Table();
        innerBackgroundTable.setBackground(ninePatchDrawable);
        innerBackgroundTable.top().left();//When we say table.top() than any item we add will start from the top

        content.add(innerBackgroundTable).pad(20).grow();
        content.row();



        //Creating name table and adding it to innerBackgroundTable
        Label nameLabel = new Label("Player Name:", labelStyle);
        nameLabel.setAlignment(Align.left);
        nameLabel.setEllipsis(true); //Троеточие, если не хватит мемта для полного текста

        patch = atlas.createPatch("input-txt-box");
        ninePatchDrawable = new NinePatchDrawable(patch);
        /*Giving textField it's background
     textFieldStyle.background =  drawable;
     But it's better to create another table and assign background to the table*/

        TextField textField = new TextField("", textFieldStyle);
        Table textFieldWrapper = new Table();
        Table nameTable = new Table();

        textFieldWrapper.add(textField).pad(10);
        textFieldWrapper.background(ninePatchDrawable);

        nameTable.pad(15);
        nameTable.defaults().space(10); //Space between all the components
        nameTable.add(nameLabel).width(120).expandX().left();
        nameTable.add(textFieldWrapper).expandX().right();//.width(180);

        innerBackgroundTable.add(nameTable).growX();
        innerBackgroundTable.row();


        //Creating audioTableLabelTable table and adding it to innerBackgroundTable
        Label musicLabel = new Label("Music", labelStyle);
        Label sfxLabel = new Label("Sfx", labelStyle);

        Table audioTableLabelTable = new Table();
        Table musicLabelTable = new Table();
        Table sfxLabelTable = new Table();

        musicLabelTable.padRight(70);
        musicLabelTable.add(musicLabel).expandX().pad(10);//Pad 10 to add margins for tables
        sfxLabelTable.add(sfxLabel).expandX().pad(10);//Pad 10 to add margins for tables

        audioTableLabelTable.pad(15);
        audioTableLabelTable.add(musicLabelTable);
        audioTableLabelTable.add(sfxLabelTable);
        audioTableLabelTable.row();

        innerBackgroundTable.add(audioTableLabelTable).growX();
        innerBackgroundTable.row();


        NinePatch patch1 = atlas.createPatch("btn-green");
        NinePatchDrawable ninePatchDrawable1 = new NinePatchDrawable(patch1);

        NinePatch patch2 = atlas.createPatch("btn-green-pressed");
        NinePatchDrawable ninePatchDrawable2 = new NinePatchDrawable(patch2);

        NinePatch patch3 = atlas.createPatch("btn-red");
        NinePatchDrawable ninePatchDrawable3 = new NinePatchDrawable(patch1);

        NinePatch patch4 = atlas.createPatch("red-pressed");
        NinePatchDrawable ninePatchDrawable4 = new NinePatchDrawable(patch2);




        MyTextButton testButton = new MyTextButton("On",atlas);
        testButton.setWidth(100);
        testButton.setHeight(80);
        testButton.setPosition(300,210);

        //Creating audioTableLabelTable table and adding it to innerBackgroundTable
//        Table audioButtonsTable = new Table();
//        Table musicButtonTable = new Table();
//        Table sfxButtonTable = new Table();
//
//
//        NinePatch patch1 = atlas.createPatch("btn-green");
//        NinePatchDrawable ninePatchDrawable1 = new NinePatchDrawable(patch1);
//
//        NinePatch patch2 = atlas.createPatch("btn-green-pressed");
//        NinePatchDrawable ninePatchDrawable2 = new NinePatchDrawable(patch2);
//
//
//        ImageTextButton testButton = new ImageTextButton("",imageTextButtonStyle);
//        testButton.getStyle().imageUp = ninePatchDrawable1;
//        testButton.getStyle().imageDown = ninePatchDrawable2;
//        testButton.setWidth(300f);
//        Label label = new Label("On",labelStyle);
//        testButton.setLabel(label);
////        testButton.setText("Off");
////        testButton.add(label);
//
//        ImageButton musicButton = new ImageButton(ninePatchDrawable1,ninePatchDrawable2);
//        musicButton.background(ninePatchDrawable);
//
//        musicButtonTable.add(testButton).expandX();
//        audioButtonsTable.add(musicButtonTable).expandX();
//        musicButton.pad(50);
//
//            //sfx Button
////        TextButton sfxButton = new TextButton("",textButtonStyle);
////        sfxButton.setText("Off");
////        sfxButtonTable.add(sfxButton);
////        audioButtonsTable.add(sfxButtonTable);
//
//        innerBackgroundTable.add(audioButtonsTable);
//        innerBackgroundTable.row();









//        stage.addActor(container);
        stage.addActor(testButton);



//		nameLabel.setAlignment(Align.topLeft);//TO set start position in its own regions
//		nameTable.add(testLabel);
//		nameTable.add(textField);
//		nameTable.pad(20); //Is to pad the whole table.
//          table.pad - margin in android.
//          cell.pad - true pad.


        content.debugAll();
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
