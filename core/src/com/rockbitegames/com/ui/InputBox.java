package com.rockbitegames.com.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.rockbitegames.com.ResourceManager;

public class InputBox extends Table{

    private TextField textField;
    private TextField.TextFieldStyle textFieldStyle;
    private Drawable defaultBg;

    public InputBox(String defaultBg) {
        textField = new TextField("", ResourceManager.Get().getTextFieldStyle());

        this.defaultBg = ResourceManager.Get().obtainDrawable(defaultBg);
        this.setBackground(this.defaultBg);
        this.add(textField).pad(10);
    }


}
