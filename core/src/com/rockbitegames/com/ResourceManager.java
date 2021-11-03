package com.rockbitegames.com;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.GdxRuntimeException;

//Singleton
public class ResourceManager {
    private static final String UI_ATLAS = "ui.atlas";
    private static final String LARGE_FONT = "font.fnt";
    private static final String MEDIUM_FONT = "medium.fnt";
    private static final String SMALL_FONT = "small.fnt";


    private static ResourceManager instance;

    private TextureAtlas textureAtlas;
    private Skin uiSkin;
    private AssetManager assetManager;//We will call it in our render methode.
    private boolean initialized = false;
    private Label.LabelStyle labelStyle;
    private TextField.TextFieldStyle textFieldStyle;
    private BitmapFont fnt;


    private ResourceManager() {

    }

    public void init() {
        if (initialized) {
            throw new GdxRuntimeException("Initializing ResourceManager twice is not allowed");
        }

        assetManager = new AssetManager();
        loadAssetManager();

        textureAtlas = assetManager.get(UI_ATLAS);
        uiSkin = new Skin(textureAtlas);

        fnt = assetManager.get(LARGE_FONT);
        labelStyle = new Label.LabelStyle();
        labelStyle.font = fnt;


        textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = fnt;
        textFieldStyle.focusedFontColor = Color.WHITE;
        textFieldStyle.disabledFontColor = Color.WHITE;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.messageFontColor = Color.WHITE;


        initialized = true;
    }

    private void loadAssetManager() {
        loadAtlases();
        loadFonts();
        loadSounds();
        loadMusic();
        loadImages();

        assetManager.finishLoading();
    }

    private void loadAtlases() {
        assetManager.load("ui.atlas", TextureAtlas.class);
    }

    private void loadFonts() {
        assetManager.load("font.fnt", BitmapFont.class);
        assetManager.load("medium.fnt", BitmapFont.class);
        assetManager.load("small.fnt", BitmapFont.class);
    }

    private void loadImages() {

    }

    private void loadMusic() {

    }

    private void loadSounds() {

    }


    public static ResourceManager Get() { // Instead of getInstance
        if (instance == null) {
            instance = new ResourceManager();
        }

        return instance;
    }

    public Drawable obtainDrawable(String name) {
        Drawable drawable = uiSkin.getDrawable(name);

        return drawable;
    }

    public Label.LabelStyle getLabelStyle() {
        return labelStyle;
    }

    public TextField.TextFieldStyle getTextFieldStyle() {
        return textFieldStyle;
    }

    public BitmapFont getFnt() {
        return fnt;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
