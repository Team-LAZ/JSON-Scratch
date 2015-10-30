package com.laz.json;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

//http://stackoverflow.com/questions/15731944/libgdx-why-is-my-button-not-responding-on-mouseclicks

public class JsonScratch extends Game {

    private int nAttack = 1;
    private int nArmor = 2;
    private int nMagic = 3;
    private double dExp = 4;

    @Override
    public void create() {
        save();
        load();
    }

    @Override
    public void render() {

    }

    //save to data class
    public void save() {
        Data data = new Data();

        data.nAttack = nAttack;
        data.nArmor = nArmor;
        data.nMagic = nMagic;
        data.dExp = dExp;

        Json json = new Json();
        writeJson("data.json", json.toJson(data));
    }

    //load from data class
    public void load() {
        String save = readJson("data.json");
        if (!save.isEmpty()) {
            Json json = new Json();
            Data data = json.fromJson(Data.class, save);

            nAttack = data.nAttack;
            nArmor = data.nArmor;
            nMagic = data.nMagic;
            dExp = data.dExp;
        }
    }

    //write data to json
    public void writeJson(String sName, String s) {
        FileHandle file = Gdx.files.local(sName);
        file.writeString(com.badlogic.gdx.utils.Base64Coder.encodeString(s), false);
    }

    //read data from json
    public String readJson(String sName) {
        FileHandle file = Gdx.files.local(sName);
        if (file != null && file.exists()) {
            String s = file.readString();
            if (!s.isEmpty()) {
                return com.badlogic.gdx.utils.Base64Coder.decodeString(s);
            }
        }
        return "";
    }

    //class used for json
    public static class Data {
        private int nAttack;
        private int nArmor;
        private int nMagic;
        private double dExp;
    }
}
