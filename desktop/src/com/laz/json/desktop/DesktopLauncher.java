package com.laz.json.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.laz.json.Data;
import com.laz.json.JsonScratch;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = Data.NAME + " " + Data.VERSION;
        config.width = Data.WIDTH;
        config.height = Data.HEIGHT;
        new LwjglApplication(new JsonScratch(), config);
	}
}
