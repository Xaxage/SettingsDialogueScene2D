package com.rockbitegames.com.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.rockbitegames.com.ResourceManager;

public class ToggleButton extends TextButton {
    private String defaultText;
    private String changedText;
    private boolean toggled = false;

    private Drawable toggledBg;//todo: replace in ToggleButton
    private Drawable toggledPressedBg;//todo: replace in ToggleButton


    public ToggleButton(String defaultText, String changedText, String toggledBg, String toggledPressedBg) {
        super(defaultText, "btn-green", "btn-green-pressed");


        init(defaultText, changedText, toggledBg, toggledPressedBg);
    }

    private void init(String defaultText, String changedText, String toggledBg, String toggledPressedBg) {
        this.defaultText = defaultText;
        this.changedText = changedText;
        this.toggledBg = ResourceManager.Get().obtainDrawable(toggledBg);
        this.toggledPressedBg = ResourceManager.Get().obtainDrawable(toggledPressedBg);


        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggled = !toggled; // true -> false
                update();
            }
        });
    }

    private void update() {
        if (toggled) {
            buttonTextLabel.setText(changedText);
            super.setCurrentPressedBg(toggledPressedBg);
            super.setCurrentBg(toggledBg);
        } else {
            buttonTextLabel.setText(defaultText);
            super.setCurrentPressedBg(defaultPressedBg);
            super.setCurrentBg(defaultBg);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
