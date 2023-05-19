package cz.blackblog.website;

import io.javalin.Javalin;
import io.javalin.jetty.JettyServer;
import io.javalin.rendering.template.JavalinJte;

import java.io.File;

public class WebServer {
    private static Javalin app;
    private static String address;
    private static CASAuthenticator auth;

    public static void launch(String address, int port){
        WebServer.address = address;
        auth = new CASAuthenticator(address);
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        JavalinJte.init();
        app = Javalin.create().start(address, port);
        app.get("/", ctx -> ctx.render("Frontpage.jte"));
    }

    public static String getAddress(){
        return address;
    }

    public static int getPort(){
        return app.port();
    }

    public static String getAuthUrl(){
        return auth.getAuthURL();
    }



}
