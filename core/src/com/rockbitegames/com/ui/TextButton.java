package com.rockbitegames.com.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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


    // todo:
    protected Drawable defaultBg;
    protected Drawable defaultPressedBg;

    private Drawable currentBg;
    private Drawable currentPressedBg;

    private boolean toggled = false;

    public TextButton(String defaultText, String defaultBg, String defaultPressedBg) {
        init(defaultText, defaultBg, defaultPressedBg);
        add(buttonTextLabel);//Adding Label to the table
    }

    private void init(String defaultText, String defaultBg, String defaultPressedBg) {
        this.fnt = new BitmapFont(Gdx.files.internal("font.fnt"));
        this.labelStyle = new Label.LabelStyle(fnt, Color.WHITE);
        this.buttonTextLabel = new Label(defaultText, labelStyle);
        buttonTextLabel.setAlignment(Align.center);
        this.clickListener = new ClickListener();
        this.setTouchable(Touchable.enabled);
        this.addListener(clickListener);

        this.defaultBg = ResourceManager.Get().obtainDrawable(defaultBg);
        this.defaultPressedBg = ResourceManager.Get().obtainDrawable(defaultPressedBg);

        currentBg = this.defaultBg;
        currentPressedBg = this.defaultPressedBg;


        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggled = !toggled; // true -> false
            }
        });
    }


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
            setBackground(currentPressedBg);
        } else {
            setBackground(currentBg);
        }


    }

    protected void setCurrentBg(Drawable currentBg) {
        this.currentBg = currentBg;
    }

    protected void setCurrentPressedBg(Drawable currentPressedBg) {
        this.currentPressedBg = currentPressedBg;
    }

}



