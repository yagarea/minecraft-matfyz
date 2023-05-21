package cz.blackblog.website;

import cz.blackblog.tools.WhiteList;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.io.File;
import java.util.Collections;

public class WebServer {
    private static Javalin app;
    private static String address;
    private static CASAuthenticator casAuth;
    private static NativeAuthenticator nativeAuth;
    private static WhiteList whiteList;
    private static PlayerAdditionStatus lastPlayerAdditionStatus;

    public static void launch(String address, int port, String userDatabase, String whiteListFile){
        // init static variables
        WebServer.address = address;
        casAuth = new CASAuthenticator(address);
        nativeAuth = new NativeAuthenticator(userDatabase);
        whiteList = new WhiteList(whiteListFile);
        // print base path for administaration purposes
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        // init Javalin
        JavalinJte.init();
        app = Javalin.create(config -> {}).start(address, port);
        // Home page
        app.get("/", ctx -> ctx.render("Frontpage.jte"));
        // Native login page
        app.get("/login/", ctx -> ctx.render("Login.jte"));
        // Native login page with error message
        app.get("/login-invalid/", ctx -> ctx.render("LoginInvalid.jte"));
        // authenticate native login
        app.post("/authenticate/", ctx -> {
            String username = ctx.formParam("username");
            String password = ctx.formParam("password");
            String passwordSHA256 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
            System.out.println(username + " " + password + " " + passwordSHA256);
            if (nativeAuth.authenticate(username, passwordSHA256)) {
                ctx.redirect("/add-player/");
            }else {
                ctx.redirect("/login-invalid/");
            }
        });
        // Try add player to whitelist
        app.post("/save-player/", ctx -> {
            String nickname = ctx.formParam("nickname");
            lastPlayerAdditionStatus = new PlayerAdditionStatus();
            try{
                whiteList.addPlayer(nickname);
            }catch (Exception e){
                lastPlayerAdditionStatus = new PlayerAdditionStatus(e.getMessage());
                System.out.println(e.getMessage());
            }
            ctx.redirect("/add-player-done/");
        });
        // Add player form
        app.get("/add-player/", ctx -> ctx.render("AddPlayer.jte"));
        // Status page of adding player
        app.get("/add-player-done/", ctx -> ctx.render("AddPlayerDone.jte", Collections.singletonMap("status", lastPlayerAdditionStatus)));
    }

    // get address server is running on
    public static String getAddress(){
        return address;
    }

    // get Port server is running on
    public static int getPort(){
        return app.port();
    }

    public static String getCasAuthURL(){
        return casAuth.getAuthURL();
    }

}
