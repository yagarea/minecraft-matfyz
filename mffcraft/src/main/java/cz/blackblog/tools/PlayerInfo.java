package cz.blackblog.tools;

import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class PlayerInfo {

    public static String getUUID(String name) throws McUUIDNotFoundException {
        return getProfile(name).getString("id");
    }

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
