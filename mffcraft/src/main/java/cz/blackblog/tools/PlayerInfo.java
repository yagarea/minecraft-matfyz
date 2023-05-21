package cz.blackblog.tools;

import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.io.*;

// This class is used in src/main/java/cz/blackblog/tools/WhiteList.java
// and src/main/java/cz/blackblog/website/WebServer.java
// to get the UUID of a player from their nickname.
public class PlayerInfo {

    // get API to get player UUID
    public static String getUUID(String name) throws McUUIDNotFoundException {
        return getProfile(name).getString("id");
    }

    // use mojang API to get player profile
    public static JSONObject getProfile(String nickname) throws RuntimeException {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + nickname);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    response.append(line);
                }
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL");
        } catch (IOException e) {
            throw new RuntimeException("Player not found");
        }

        if (response.length() == 0) {
            throw new RuntimeException("Empty response");
        }

        JSONObject json = new JSONObject(response.toString());
        if (json.has("errorMessage")) {
            throw new RuntimeException("Error: " + json.getString("errorMessage"));
        } else {
            return json;
        }
    }
}
