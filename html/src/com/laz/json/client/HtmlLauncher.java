package com.laz.json.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.laz.json.Data;
import com.laz.json.JsonScratch;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(Data.WIDTH, Data.HEIGHT);
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new JsonScratch();
    }
}