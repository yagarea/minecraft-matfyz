package cz.blackblog.website;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;

import java.nio.file.Path;

public class PageRenderer {
    CodeResolver codeResolver;
    TemplateEngine templateEngine;

    public PageRenderer() {
        this.codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "java", "cz", "blackblog", "website", "teplates"));
        this.templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
    }

    public String render(String filename, java.util.Map<String, Object> params) {
        StringOutput output = new StringOutput();
        templateEngine.render(filename + ".jte", params, output);
        return output.toString();
    }
}
