package cz.blackblog;

import cz.blackblog.website.WebServer;
import cz.blackblog.tools.PlayerInfo;
import cz.blackblog.tools.McUUIDNotFoundException;

public class Main {
    public static void main(String[] args) throws McUUIDNotFoundException {
        WebServer.launch("mc.matfyz.cz", 8088);
    }
}