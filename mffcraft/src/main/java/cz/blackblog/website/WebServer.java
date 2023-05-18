package cz.blackblog.website;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.io.File;

public class WebServer {

    public static void launch(int port){
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        JavalinJte.init();
        Javalin app = Javalin.create().start(port);
        app.get("/", ctx -> ctx.render("Frontpage.jte"));
    }

}
