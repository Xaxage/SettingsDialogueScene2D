package com.rockbitegames.com;

import com.badlogic.gdx.Game;
import com.rockbitegames.com.screen.LoadingScreen;

public class TestGame extends Game {


    public TestGame() {


    }

    @Override
    public void create() {
        ResourceManager.Get().init();
        setScreen(new LoadingScreen(this));
    }
}
