package com.rockbitegames.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.GdxRuntimeException;

//Singleton
public class ResourceManager {

    private  static ResourceManager instance;

    private TextureAtlas textureAtlas;
    private Skin uiSkin;

    private boolean initialized = false;
    private Label.LabelStyle labelStyle;

    private ResourceManager() {

    }

    public void init() {
        if(initialized) {
            throw new GdxRuntimeException("Initializing ResourceManager twice is not allowed");
        }

        FileHandle atlasHandle = Gdx.files.internal("atlas.atlas"); //todo: please rename this
        textureAtlas = new TextureAtlas(atlasHandle);
        uiSkin = new Skin(textureAtlas);

        BitmapFont fnt = new BitmapFont(Gdx.files.internal("font.fnt"));
        labelStyle = new Label.LabelStyle();
        labelStyle.font = fnt;


        initialized = true;
    }

    public static ResourceManager Get() { // Instead of getInstance
        if(instance == null) {
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

}
