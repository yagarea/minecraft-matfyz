package cz.blackblog.website;

public class CASAuthenticator {
    private final String casUrl = "https://cas.cuni.cz/cas/";
    private String returnUrl;
    private int version = 3;

    public CASAuthenticator(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getAuthURL(){
        return casUrl + "login?service=" + returnUrl;
    }
}
