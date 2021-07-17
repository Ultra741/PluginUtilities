package ultradev.pluginutilities.api.commands;

public enum CommandError {

    NOT_A_PLAYER("You must be a player to do this!"),
    NO_PERMISSION("You don't have permission to do this!");

    private final String error;

    CommandError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
