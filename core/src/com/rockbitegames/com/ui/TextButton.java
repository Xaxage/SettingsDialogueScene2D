package com.rockbitegames.com.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.Align;
import com.rockbitegames.com.ResourceManager;

import java.util.HashMap;
import java.util.Map;

// todo: refactor this to use asset manager, and also to pass background region names to constructors

public class TextButton extends Table {
    private ClickListener clickListener;
    private TextureAtlas textureAtlas;
    private BitmapFont fnt;
    private Label.LabelStyle labelStyle;
    protected Label buttonTextLabel;
    private Map<String, NinePatchDrawable> ninePatchDrawableMap = new HashMap<>();


    // todo:
    private Drawable clickedBg;
    private Drawable toggledBg;
    private Drawable normalBg;

    private boolean toggled = false;

    public TextButton(String labelText) {
        init(labelText);
        add(buttonTextLabel);//Adding Label to the table
    }

    private void init(String text) {
        this.fnt = new BitmapFont(Gdx.files.internal("font.fnt"));
        this.labelStyle = new Label.LabelStyle(fnt, Color.WHITE);
        this.buttonTextLabel = new Label(text, labelStyle);
        buttonTextLabel.setAlignment(Align.center);
        this.clickListener = new ClickListener();
        this.setTouchable(Touchable.enabled);
        this.addListener(clickListener);
//        fillNinePatches();

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggled = !toggled; // true -> false
            }
        });
    }


//    private void fillNinePatches() {
//        NinePatch patch;
//        NinePatchDrawable ninePatchDrawable;
//
//        //Create skin add atlas then obtain it
//
//        patch = textureAtlas.createPatch("btn-green");
//        ninePatchDrawable = new NinePatchDrawable(patch);
//        ninePatchDrawableMap.put("btn-green", ninePatchDrawable);
//        patch = textureAtlas.createPatch("btn-green-pressed");
//        ninePatchDrawable = new NinePatchDrawable(patch);
//        ninePatchDrawableMap.put("btn-green-pressed", ninePatchDrawable);
//
//        patch = textureAtlas.createPatch("btn-red");
//        ninePatchDrawable = new NinePatchDrawable(patch);
//        ninePatchDrawableMap.put("btn-red", ninePatchDrawable);
//        patch = textureAtlas.createPatch("btn-red-pressed");
//        ninePatchDrawable = new NinePatchDrawable(patch);
//        ninePatchDrawableMap.put("btn-red-pressed", ninePatchDrawable);
//
//        System.out.println(ninePatchDrawableMap);
//
//
//    }

    @Override
    public void act(float delta) {
        super.act(delta);

//        if (clickListener.isVisualPressed()) {
//            if (!toggled) {
//                setBackground(ninePatchDrawableMap.get("btn-green-pressed"));
//            } else {
//                setBackground(ninePatchDrawableMap.get("btn-red-pressed"));
//            }
//        } else {
//            if (!toggled) {
//                setBackground(ninePatchDrawableMap.get("btn-green"));
//                buttonTextLabel.setText("On");
//            } else {
//                setBackground(ninePatchDrawableMap.get("btn-red"));
//                buttonTextLabel.setText("Off");
//            }
//
//        }

        if (clickListener.isVisualPressed()) {
            setBackground(ResourceManager.Get().obtainDrawable("btn-green-pressed"));
        } else {
            setBackground(ResourceManager.Get().obtainDrawable("btn-green"));
        }


    }
}



