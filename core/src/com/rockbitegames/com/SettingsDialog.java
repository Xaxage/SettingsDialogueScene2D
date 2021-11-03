package com.rockbitegames.com;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.rockbitegames.com.ui.AbstractDialog;
import com.rockbitegames.com.ui.InputBox;
import com.rockbitegames.com.ui.TextButton;
import com.rockbitegames.com.ui.ToggleButton;

public class SettingsDialog extends AbstractDialog {

    public SettingsDialog() {
        super("Settings");
        buildContent();
    }

    @Override
    protected Table buildContent() {
        Table table = new Table();

        Table playerContainer = buildPlayerContainer();
        Table soundContainer = buildSfxContainer();
        Table accountContainer = buildAccountContainer();
        Table switchSaveContainer = buildSwitchSaveContainer();

        table.top();

        table.add(playerContainer).growX().pad(15);
        table.row();

        table.add(soundContainer).growX().padTop(20).pad(15);
        table.row();

        table.add(accountContainer).growX().pad(15).padTop(40);
        table.row();

        table.add(switchSaveContainer);
        table.row();


//        debugAll();
        return table;
    }

    private Table buildPlayerContainer() {
        Table table = new Table();
        table.defaults().space(10).padTop(20);

        Label nameLabel = new Label("Player Name:", ResourceManager.Get().getLabelStyle());
        nameLabel.setAlignment(Align.left);
        nameLabel.setEllipsis(true); //Троеточие, если не хватит меcта для полного текста

        table.add(nameLabel).width(120).left();

        table.add(new InputBox("input-txt-box")).growX();


        return table;
    }

    private Table buildSfxContainer() {
        Table table = new Table();//Their parent table
        Table musicTable = new Table();//Child table
        Table soundTable = new Table();//Child table

        table.defaults().space(55).padTop(20);

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

    private Table buildAccountContainer() {
        Table table = new Table();

        table.defaults().space(20).padTop(20);


        Label googleLabel = new Label("Google", ResourceManager.Get().getLabelStyle());
        googleLabel.setAlignment(Align.left);

        ToggleButton linkButton = new ToggleButton("Link", "Unlink", "btn-red", "btn-red-pressed");

        table.add(googleLabel).expandX().width(120).left();
        table.add(linkButton).expandX().width(120).right();

        return table;
    }

    private Table buildSwitchSaveContainer() {
        Table table = new Table();
        table.defaults().space(30);

        TextButton switchButton = new TextButton("Switch account", "btn-green", "btn-green-pressed");
        switchButton.pad(10);

        TextButton saveButton = new TextButton("Save", "btn-yellow", "btn-yellow-pressed");
        switchButton.pad(10);

        Label UID = new Label("uid:12jk31298312m412", ResourceManager.Get().getLabelStyle());


        table.add(switchButton).grow().row();
        table.add(saveButton).grow().row();
        table.add(UID);
        return table;
    }

    @Override
    protected void declareDialogSize() {
        setSize(300, 400);
    }

    public void setData() {

    }


}
