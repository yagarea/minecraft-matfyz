package cz.blackblog;

import cz.blackblog.website.WebServer;
import cz.blackblog.tools.PlayerInfo;
import cz.blackblog.tools.McUUIDNotFoundException;

public class Main {
    public static void main(String[] args) throws McUUIDNotFoundException {
        try {
            System.out.println(PlayerInfo.getUUID("yagarea"));
        } catch (McUUIDNotFoundException e) {
            throw new RuntimeException(e);
        }
        WebServer.launch(8080);
    }
}