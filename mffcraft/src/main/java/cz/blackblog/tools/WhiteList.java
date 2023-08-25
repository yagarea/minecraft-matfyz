package cz.blackblog.tools;

import org.json.JSONArray;
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
    private JSONArray readWhiteList() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(this.whiteListFilePath)));
        return new JSONArray(content);
    }

    // write JSONObject to whitelist.json
    private void writeWhiteList(JSONArray jsonArray) throws IOException {
        String output = jsonArray.toString();
        Files.write(Paths.get(this.whiteListFilePath), output.getBytes());
    }

    // add player to whitelist
    public void addPlayer(String name) throws IOException, RuntimeException {
        JSONArray ja = this.readWhiteList();
        JSONObject playerInfo = PlayerInfo.getProfile(name);
        ja.put(playerInfo);
        this.writeWhiteList(ja);
    }
}
