package cz.blackblog;

import cz.blackblog.website.WebServer;

public class Main {
    public static void main(String[] args) {
        WebServer.launch("127.0.0.1", 8080, "src/static/users", "src/static/whitelist.json");
    }
}