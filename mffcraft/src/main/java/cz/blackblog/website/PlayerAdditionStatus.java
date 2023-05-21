package cz.blackblog.website;

// simple dataclass for storing status of player addition
public class PlayerAdditionStatus {
    private final String message;
    private final boolean isOk;

    public PlayerAdditionStatus() {
        this.message = "Player was successfully added";
        this.isOk = true;
    }

    public PlayerAdditionStatus(String message) {
        this.message = message;
        this.isOk = false;
    }

    public String getMessage() {
        return message;
    }

    public boolean isOk() {
        return isOk;
    }
}
