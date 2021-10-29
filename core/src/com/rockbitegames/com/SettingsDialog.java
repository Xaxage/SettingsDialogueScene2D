package com.rockbitegames.com;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.rockbitegames.com.ui.AbstractDialog;
import com.rockbitegames.com.ui.TextButton;

public class SettingsDialog extends AbstractDialog {

    public SettingsDialog() {
        super("Settings");
        buildContent();
    }

    @Override
    protected Table buildContent() {

        Table table = new Table();

//        Table playerContainer = buildPlayerContainer();
        Table sfxContainer = buildSfxContainer();
//        Table accountContainer = buildAccountContainer();

//        TextButton saveButton = new TextButton("hey");
//        table.add(saveButton).center().expandX();
        table.top();

        table.add(sfxContainer);

        row();

        // todo: add uid label

        debugAll();
        return table;
    }

    private Table buildSfxContainer() {
        Table table = new Table();//Their parent table
        Table musicTable = new Table();//Child table
        Table soundTable = new Table();//Child table

        table.defaults().space(30).padTop(20);

        Label musicLabel = new Label("Music", ResourceManager.Get().getLabelStyle());
        Label sfxLabel = new Label("Sfx", ResourceManager.Get().getLabelStyle());

        TextButton musicButton = new TextButton("On"); // todo: instead create toggle text button
        TextButton sfxButton = new TextButton("On");// todo: instead create toggle text button

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
