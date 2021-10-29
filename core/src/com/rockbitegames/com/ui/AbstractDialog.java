package com.rockbitegames.com.ui;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.rockbitegames.com.ResourceManager;

public abstract class AbstractDialog extends Table {

    public AbstractDialog(String title) {
        build(title);
        declareDialogSize();

    }

    private void build(String title) {
        setBackground(ResourceManager.Get().obtainDrawable("dialog-inside-box"));

        Table header = buildHeader(title);
        add(header).growX();
        row();

        Table content = buildContent();
        content.setBackground(ResourceManager.Get().obtainDrawable("dialog-inside-box"));

        pad(5);
        add(content).grow().pad(5);
    }

//    private Stack buildHeader(String title) {
//        Stack headerStack = new Stack();
//        Table headerCoverTable = new Table();//Table that contains our cover table and cover itself
//
//        Table cover = new Table();//header flexible itself
//
//        cover.setBackground(ResourceManager.Get().obtainDrawable("header-flexible"));
//        cover.padRight(50).padLeft(50);
//        headerCoverTable.add(cover).size(250, 60).expand().top().center();
//
//        Label titleLabel = new Label(title, ResourceManager.Get().getLabelStyle());
//        cover.add(titleLabel).padBottom(10).padLeft(50).padRight(40);
//
//        Table headerCrossButtonTable = new Table();
//        ImageButton cross = new ImageButton(ResourceManager.Get().obtainDrawable("ic-close"));
//        headerCrossButtonTable.add(cross).size(45).expandX().right().padRight(15);
//
//        headerStack.add(headerCoverTable);
//        headerStack.add(headerCrossButtonTable);
//
////        headerCoverTable.debug();
//        headerCrossButtonTable.debug();
//        return headerStack;
//    }

    private Table buildHeader(String title) {
        final Table headerTable = new Table();
        headerTable.padLeft(10).padRight(10);
        final ImageButton crossButton = new ImageButton(ResourceManager.Get().obtainDrawable("ic-close"));

        final Label titleLabel = new Label(title, ResourceManager.Get().getLabelStyle());
        final Table coverTable = new Table();
        coverTable.setBackground(ResourceManager.Get().obtainDrawable("header-flexible"));
        coverTable.padRight(50).padLeft(50);
        coverTable.add(titleLabel).padBottom(10).padLeft(50).padRight(40);

        final int crossImageSize = 45;
        headerTable.add().size(crossImageSize);
        headerTable.add(coverTable).size(250, 60).expandX();
        headerTable.add(crossButton).size(crossImageSize);


        return headerTable;
    }

    protected abstract Table buildContent();

    public void show() {//Is to open a dialog
        setVisible(true);
    }

    public void hide() {//Is to close a dialog
        setVisible(false);
    }

    protected abstract void declareDialogSize();//So we later must override it later and get set size
}
