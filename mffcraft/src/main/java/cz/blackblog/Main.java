package cz.blackblog;

import cz.blackblog.website.WebServer;

public class Main {

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            WebServer.launch("127.0.0.1", 8080, "src/static/users", "src/static/whitelist.json");
        } else if (args.length != 4) {
            System.out.println("Usage: java -jar <jarfile> <address> <port> <userDatabase> <whiteListFile>");
            System.exit(1);
        }else{
            WebServer.launch(args[0], Integer.parseInt(args[1]), args[2], args[3]);
        }
    }
}