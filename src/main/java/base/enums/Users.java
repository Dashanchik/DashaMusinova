package base.enums;

public enum Users {
    PITER("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String name;

    Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
