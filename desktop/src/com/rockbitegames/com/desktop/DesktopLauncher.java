package com.rockbitegames.com.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rockbitegames.com.DialogTestGame;
import com.rockbitegames.com.SettingsDialog;
import com.rockbitegames.com.TestGame;
import com.rockbitegames.com.screen.LoadingScreen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280/3;
		config.height = 720;
		new LwjglApplication(new TestGame(), config);
	}
}
