package cz.blackblog.tools;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// this class is used for adding players to whitelist.json
public class WhiteList {
    String whiteListFilePath;

    public WhiteList(String pathToFile) {
        this.whiteListFilePath = pathToFile;
    }

    // get whitelist as JSONObject
    private JSONObject readWhiteList() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(this.whiteListFilePath)));
        return new JSONObject(content);
    }

    // write JSONObject to whitelist.json
    private void writeWhiteList(JSONObject json) throws IOException {
        Files.write(Paths.get(this.whiteListFilePath), json.toString().getBytes());
    }

    // add player to whitelist
    public void addPlayer(String name) throws IOException, RuntimeException {
        JSONObject json = this.readWhiteList();
        JSONObject playerInfo = PlayerInfo.getProfile(name);
        json.append("whitelist", playerInfo); // append to root array
        this.writeWhiteList(json);
    }
}
