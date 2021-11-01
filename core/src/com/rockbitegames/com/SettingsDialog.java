package com.rockbitegames.com;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.Align;
import com.rockbitegames.com.ui.AbstractDialog;
import com.rockbitegames.com.ui.InputBox;
import com.rockbitegames.com.ui.ToggleButton;

public class SettingsDialog extends AbstractDialog {

    public SettingsDialog() {
        super("Settings");
        buildContent();
    }

    @Override
    protected Table buildContent() {
        Table table = new Table();

        Table playerContainer = buildPlayerContainer();//todo
        Table soundContainer = buildSfxContainer();
//        Table accountContainer = buildAccountContainer();//todo:

        table.top();

        table.add(playerContainer);
        table.row();

        table.add(soundContainer);
        row();

        // todo: add uid label

        return table;
    }

    private Table buildPlayerContainer() {
        Table table = new Table();
        table.defaults().space(40).padTop(20);

        Label nameLabel = new Label("Player Name:", ResourceManager.Get().getLabelStyle());
        nameLabel.setAlignment(Align.left);
        nameLabel.setEllipsis(true); //Троеточие, если не хватит меcта для полного текста

        table.add(nameLabel).width(120).expandX().left();
        table.add(new InputBox("input-txt-box"));

//
//        patch = atlas.createPatch("input-txt-box");
//        ninePatchDrawable = new NinePatchDrawable(patch);
//        /*Giving textField it's background
//     textFieldStyle.background =  drawable;
//     But it's better to create another table and assign background to the table*/
//
//        TextField textField = new TextField("", textFieldStyle);
//        Table textFieldWrapper = new Table();
//        Table nameTable = new Table();
//
//        textFieldWrapper.add(textField).pad(10);
//        textFieldWrapper.background(ninePatchDrawable);
//
//        nameTable.pad(15);
//        nameTable.defaults().space(10); //Space between all the components
//        nameTable.add(nameLabel).width(120).expandX().left();
//        nameTable.add(textFieldWrapper).expandX().right();//.width(180);
//
//        innerBackgroundTable.add(nameTable).growX();
//        innerBackgroundTable.row();

        return table;
    }

    private Table buildSfxContainer() {
        Table table = new Table();//Their parent table
        Table musicTable = new Table();//Child table
        Table soundTable = new Table();//Child table

        table.defaults().space(30).padTop(20);

        Label musicLabel = new Label("Music", ResourceManager.Get().getLabelStyle());
        Label sfxLabel = new Label("Sfx", ResourceManager.Get().getLabelStyle());

        ToggleButton musicButton = new ToggleButton("On", "Off",
                "btn-red", "btn-red-pressed");
        ToggleButton sfxButton = new ToggleButton("On", "Off",
                "btn-red", "btn-red-pressed");

        musicTable.add(musicLabel);
        musicTable.row();
        musicTable.add(musicButton).width(150);

        soundTable.add(sfxLabel);
        soundTable.row();
        soundTable.add(sfxButton).width(150);

        table.add(musicTable);
        table.add(soundTable);

        return table;
    }

    @Override
    protected void declareDialogSize() {
        setSize(300, 400);
    }

    public void setData() {

    }

}
